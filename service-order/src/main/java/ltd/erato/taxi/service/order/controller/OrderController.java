package ltd.erato.taxi.service.order.controller;

import ltd.erato.taxi.service.order.entity.Order;
import ltd.erato.taxi.service.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2023-06-04 22:20:33
 */
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Order> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.orderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param order 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Order> add(Order order) {
        return ResponseEntity.ok(this.orderService.insert(order));
    }

    /**
     * 编辑数据
     *
     * @param order 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Order> edit(Order order) {
        return ResponseEntity.ok(this.orderService.update(order));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.orderService.deleteById(id));
    }

}

