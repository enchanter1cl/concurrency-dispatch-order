package ltd.erato.taxi.service.map.controller;

import ltd.erato.taxi.internal.common.dto.AroundSearchDTO;
import ltd.erato.taxi.internal.common.dto.ResponseResult;
import ltd.erato.taxi.service.map.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/terminal")
public class TerminalController {

    @Autowired
    TerminalService terminalService;

    /**
     * 终端搜索 圆形范围
     * @param center
     * @param radius
     * @return
     */
    @GetMapping("/aroundSearch")
    public ResponseResult<AroundSearchDTO> aroundSearch(String center, Integer radius) {
        return terminalService.aroundSearch(center, radius);
    }
}
