package ltd.erato.taxi.api.passenger.controller;

import lombok.extern.slf4j.Slf4j;
import ltd.erato.taxi.api.passenger.remote.SvcOrderClient;
import ltd.erato.taxi.internal.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    SvcOrderClient svcOrderClient;

    /**
     * 测试实时派单
     * @param orderId
     * @return
     */
    @GetMapping("/test-real-time-order/{orderId}")
    public ResponseResult testDispatchOrder(@PathVariable("orderId") Long orderId) {
        log.info("收到订单: "+orderId);
        return svcOrderClient.testDispatchOrder(orderId);
    }
}
