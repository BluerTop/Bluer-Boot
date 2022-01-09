package top.bluer.common.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: bluer-boot
 * @description: 定义正常响应的API统一返回体
 * @author: bluer
 * @date: 2021-10-15 15:45
 * codes: 扁鹊
 **/
@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private boolean success = true;
    private T data;

    @JsonIgnore
    private ResultCode resultCode;

    public Result() {
    }

    public Result(T data, ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    /**
     * 不带参数的返回封装
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    /**
     * 带参数的返回封装
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }
}
