package ltd.erato.taxi.service.map.service;

import ltd.erato.taxi.internal.common.dto.AroundSearchDTO;
import ltd.erato.taxi.internal.common.dto.ResponseResult;
import ltd.erato.taxi.service.map.remote.TerminalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminalService {

    @Autowired
    TerminalClient terminalClient;

    /**
     * 周边搜索
     * @param center
     * @param radius
     * @return
     */
    public ResponseResult<AroundSearchDTO> aroundSearch(String center, Integer radius) {

        return terminalClient.aroundSearch(center, radius);
    }
}
