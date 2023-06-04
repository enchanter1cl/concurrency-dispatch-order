package ltd.erato.taxi.internal.common.dto;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseResult<T> {

    private Integer code;
    private String message;
    private T data;

    public static <T> ResponseResult success() {
        return new ResponseResult().setCode(200).setMessage("success!");
    }

    public static <T> ResponseResult success(T data) {
        return new ResponseResult().setCode(200).setMessage("success!").setData(data);
    }

    public static <T> ResponseResult fail() {
        return new ResponseResult();
    }

    /**
     * custom status
     * @param code
     * @param message
     * @return
     * @param <T>
     */
    public static <T> ResponseResult fail(int code, String message) {
        return new ResponseResult().setCode(code).setMessage(message);
    }

    /**
     * custom status
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static ResponseResult fail(int code, String message, String data) {
        return new ResponseResult().setCode(code).setMessage(message).setData(data);
    }

    /**
     * other fail.  偷懒，兜底
     * @param data
     * @return
     * @param <T>
     */
    public static <T> ResponseResult fail(T data) {
        return new ResponseResult().setData(data);
    }
}
