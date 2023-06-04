package ltd.erato.taxi.service.order.remote;

import ltd.erato.taxi.internal.common.dto.AroundSearchDTO;
import ltd.erato.taxi.internal.common.dto.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-map")
public interface SvcMapClient {

    @GetMapping("/terminal/aroundSearch")
    public ResponseResult<AroundSearchDTO> aroundSearch(@RequestParam("center") String center, @RequestParam("radius") Integer radius);
}
