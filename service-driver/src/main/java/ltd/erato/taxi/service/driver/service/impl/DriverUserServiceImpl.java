package ltd.erato.taxi.service.driver.service.impl;

import ltd.erato.taxi.service.driver.entity.DriverUser;
import ltd.erato.taxi.service.driver.dao.DriverUserDao;
import ltd.erato.taxi.service.driver.service.DriverUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * (DriverUser)表服务实现类
 *
 * @author makejava
 * @since 2023-06-04 22:13:28
 */
@Service("driverUserService")
public class DriverUserServiceImpl implements DriverUserService {
    @Resource
    private DriverUserDao driverUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DriverUser queryById(Long id) {
        return this.driverUserDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param driverUser 实例对象
     * @return 实例对象
     */
    @Override
    public DriverUser insert(DriverUser driverUser) {
        this.driverUserDao.insert(driverUser);
        return driverUser;
    }

    /**
     * 修改数据
     *
     * @param driverUser 实例对象
     * @return 实例对象
     */
    @Override
    public DriverUser update(DriverUser driverUser) {
        this.driverUserDao.update(driverUser);
        return this.queryById(driverUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.driverUserDao.deleteById(id) > 0;
    }
}
