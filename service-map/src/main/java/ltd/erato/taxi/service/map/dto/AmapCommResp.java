package ltd.erato.taxi.service.map.dto;

import lombok.Data;

/**
 * 高德的统一返回体
 */
@Data
public class AmapCommResp<T> {

    private String errcode;
    private String errmsg;
    private String errdetail;

    private T data;
}
