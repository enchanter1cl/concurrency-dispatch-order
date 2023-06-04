package ltd.erato.taxi.service.order.service.impl;

import lombok.extern.slf4j.Slf4j;
import ltd.erato.taxi.internal.common.dto.AroundSearchDTO;
import ltd.erato.taxi.internal.common.dto.ResponseResult;
import ltd.erato.taxi.service.order.entity.Order;
import ltd.erato.taxi.service.order.dao.OrderDao;
import ltd.erato.taxi.service.order.remote.SvcMapClient;
import ltd.erato.taxi.service.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2023-06-04 22:20:33
 */
@Service("orderService")
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Autowired
    SvcMapClient svcMapClient;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Long id) {
        return this.orderDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        this.orderDao.insert(order);
        return order;
    }

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderDao.update(order);
        return this.queryById(order.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.orderDao.deleteById(id) > 0;
    }

    /**
     * 实时派单
     * @param orderId
     * @return
     */
    public synchronized ResponseResult dispatchOrder(Long orderId) {

        /* 获取乘客位置 */
        Order orderDb = queryById(orderId);
        if (orderDb == null) return ResponseResult.fail("NullPointer");
        String depLng = orderDb.getDepLng();
        String depLat = orderDb.getDepLat();
          ///39.897927,116.41905
        String depPoint = depLat + "," + depLng;

        /* 搜索终端 */
        //log.info("在半径为"+"4000"+"m寻找车辆");
        ResponseResult<AroundSearchDTO> mapResp = svcMapClient.aroundSearch(depPoint, 4000);
        AroundSearchDTO aroundSearchDTO = mapResp.getData();

        /* 解析终端 */
        if (aroundSearchDTO == null) {
            return ResponseResult.fail("附近无车");
        }
        List<AroundSearchDTO.AroundSearchTerminal> terminals = aroundSearchDTO.getResults();
        List<String> tids = terminals.stream()
                .map(AroundSearchDTO.AroundSearchTerminal::getTid)
                .collect(Collectors.toList());
        //查库 tids 转为 driverIds todo_list
        ArrayList<Long> driverIds = new ArrayList<>();
        driverIds.add(8L);

        /* 给指定终端派单 */
          /* 1 终端是否有进行中的订单 */
        List<Long> availableDriverIds = driverIds.stream()
                .filter(driverId -> {
            boolean idleFlag = isDriverOrderGoingOn(driverId) == 0;
                    if (!idleFlag) return false;

            /* 方式一 系统直接把订单分配给司机 */
                    //查 driver 库查司机信息
                    orderDb.setDriverId(driverId);
                    orderDb.setDriverPhone("11111111111");
                    orderDb.setState(3);
                    orderDao.update(orderDb);
                    log.info("为订单"+orderId+"分配了司机"+driverId);
                    return true;
                }).collect(Collectors.toList());

        if (availableDriverIds.isEmpty()) {
            return ResponseResult.fail("无可用司机");
        }

        return ResponseResult.success(orderId+"派单完成");
    }


    /**
     * 进行中的订单有几个 0还是1
     * @param driverId
     * @return
     */
    private int isDriverOrderGoingOn(Long driverId) {
        Order order = new Order();
        order.setDriverId(driverId);

        List<Order> driverGoingOns = orderDao.isDriverOrderGoingOn(order);
        return driverGoingOns.size();
    }
}
