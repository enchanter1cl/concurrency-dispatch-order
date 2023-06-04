package ltd.erato.taxi.service.driver.service;

import ltd.erato.taxi.service.driver.entity.DriverUser;

/**
 * (DriverUser)表服务接口
 *
 * @author makejava
 * @since 2023-06-04 22:13:28
 */
public interface DriverUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DriverUser queryById(Long id);


    /**
     * 新增数据
     *
     * @param driverUser 实例对象
     * @return 实例对象
     */
    DriverUser insert(DriverUser driverUser);

    /**
     * 修改数据
     *
     * @param driverUser 实例对象
     * @return 实例对象
     */
    DriverUser update(DriverUser driverUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
