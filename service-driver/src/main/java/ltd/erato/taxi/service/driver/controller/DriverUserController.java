package ltd.erato.taxi.service.driver.controller;

import ltd.erato.taxi.service.driver.entity.DriverUser;
import ltd.erato.taxi.service.driver.service.DriverUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * (DriverUser)表控制层
 *
 * @author makejava
 * @since 2023-06-04 22:13:26
 */
@RestController
@RequestMapping("driverUser")
public class DriverUserController {
    /**
     * 服务对象
     */
    @Resource
    private DriverUserService driverUserService;



    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DriverUser> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.driverUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param driverUser 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DriverUser> add(DriverUser driverUser) {
        return ResponseEntity.ok(this.driverUserService.insert(driverUser));
    }

    /**
     * 编辑数据
     *
     * @param driverUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DriverUser> edit(DriverUser driverUser) {
        return ResponseEntity.ok(this.driverUserService.update(driverUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.driverUserService.deleteById(id));
    }

}

