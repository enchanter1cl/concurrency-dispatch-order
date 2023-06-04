package ltd.erato.taxi.service.map.remote;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import ltd.erato.taxi.internal.common.dto.AroundSearchDTO;
import ltd.erato.taxi.internal.common.dto.ResponseResult;
import ltd.erato.taxi.internal.common.response.TerminalResponse;
import ltd.erato.taxi.service.map.constant.AmapConfigConstants;
import ltd.erato.taxi.service.map.dto.AmapCommResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * 请求高德开放api - 终端api
 */
@Service
public class TerminalClient {
    @Value("${amap.key}")
    private String amapKey;

    @Value("${amap.sid}")
    private String sid;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseResult<TerminalResponse> add(String name) {

        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.TERMINAL_ADD_URL);
        url.append("?");
        url.append("key=" + amapKey);
        url.append("&");
        url.append("sid=" + sid);
        url.append("&");
        url.append("name=" + name);

        /*send*/
        ResponseEntity<String> forEntity = restTemplate.postForEntity(url.toString(), null, String.class);

        /*parse json*/
        /**
         * {
         *     "errcode":"10000",
         *     "errmsg":"OK",
         *     "errdetail":"",
         *     "data": {
         *         "name":"车辆2",
         *         "tid":"77777",
         *         "sid":"99999"
         *     }
         * }
         */
        String bodyStr = forEntity.getBody();
        AmapCommResp<TerminalResponse> amapResp = JSON.parseObject(bodyStr, new TypeReference<AmapCommResp<TerminalResponse>>() {
        });
        //amapResp 不必判空，因为可以确定高德不管错不错 给的 resp 一定有body 且 body一定为 AmapCommResp 结构
        TerminalResponse terminalResponseFromAmap = amapResp.getData();
        //但 里边这层得判 NullPointer
        if (terminalResponseFromAmap == null) return ResponseResult.fail(terminalResponseFromAmap);

        return ResponseResult.success(terminalResponseFromAmap);
    }

    public ResponseResult<AroundSearchDTO> aroundSearch(String center, Integer radius) {

        StringBuilder url = new StringBuilder();
        url.append("https://tsapi.amap.com/v1/track/terminal/aroundsearch");
        url.append("?");
        url.append("key=" + amapKey);
        url.append("&");
        url.append("sid=" + sid);
        url.append("&");
        url.append("center=" + center);
        url.append("&");
        url.append("radius=" + radius);

        ResponseEntity<String> forEntity = restTemplate.postForEntity(URI.create(url.toString()), null, String.class);

        String bodyStr = forEntity.getBody();
        Type type = new TypeReference<AmapCommResp<AroundSearchDTO>>() {}.getType();
        //amapResp 不必判空，因为可以确定高德不管错不错 给的 resp 一定有body 且 body一定为 AmapCommResp 结构
        AmapCommResp<AroundSearchDTO> amapResp = JSON.parseObject(bodyStr, type);
        //但 里边这层得判 NUllPointer
        AroundSearchDTO aroundSearchDTOFromAmap = amapResp.getData();
        if (aroundSearchDTOFromAmap == null) return ResponseResult.fail(aroundSearchDTOFromAmap);

        return ResponseResult.success(aroundSearchDTOFromAmap);
    }
}
