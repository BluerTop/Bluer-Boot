package top.bluer.common.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: bluer-boot
 * @description: 定义异常响应的API统一返回体
 * @author: bluer
 * @date: 2021-10-15 15:51
 * codes: 扁鹊
 **/
@Data
@Builder
public class ErrorResult implements Serializable {
    private Integer code;
    private String message;
    private boolean success = false;

    @JsonIgnore
    private ResultCode resultCode;

    public static ErrorResult error() {
        return ErrorResult.builder().resultCode(ResultCode.INTERNAL_ERROR).build();
    }

    public static ErrorResult error(String message) {
        return ErrorResult.builder().code(ResultCode.INTERNAL_ERROR.code()).message(message).build();
    }

    public static ErrorResult error(Integer code, String message) {
        return ErrorResult.builder().code(code).message(message).build();
    }

    public static ErrorResult error(ResultCode resultCode, String message) {
        return ErrorResult.builder().resultCode(resultCode).message(message).build();
    }
}
