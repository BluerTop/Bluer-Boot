package top.bluer.common.exception;

import top.bluer.common.api.ResultCode;

/**
 * @program: bluer-boot
 * @description: 自定义业务异常类
 * @author: bluer
 * @date: 2021-10-15 16:47
 * codes: 扁鹊
 **/
public class BizException extends BaseException {
    public BizException(ResultCode resultCode) {
        super(resultCode);
    }
}