package ltd.erato.taxi.api.passenger.remote;

import ltd.erato.taxi.internal.common.dto.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("service-order")
public interface SvcOrderClient {

    @GetMapping("/test-real-time-order/{orderId}")
    public ResponseResult testDispatchOrder(@PathVariable("orderId") Long orderId);

}
