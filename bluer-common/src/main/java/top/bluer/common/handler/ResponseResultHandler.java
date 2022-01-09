package top.bluer.common.handler;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import top.bluer.common.annotation.ResponseResult;
import top.bluer.common.api.ErrorResult;
import top.bluer.common.api.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Objects;

/**
 * @program: bluer-boot
 * @description: 响应体处理器
 * @author: bluer
 * @date: 2021-10-15 16:18
 * codes: 扁鹊
 * 统一处理响应体，用Result.success静态方法包装，
 * 在API接口使用时就可以直接返回原始类型
 **/
@RestControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    /**
     * 使用统一返回体的标识
     */
    private static final String RESPONSE_RESULT_ANNOTATION = "RESPONSE-RESULT-ANNOTATION";

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(sra).getRequest();
        ResponseResult responseResult = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANNOTATION);
        // 判断返回体是否需要处理
        return responseResult != null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 异常响应体则直接返回code+message的消息体
        if (body instanceof ErrorResult) {
            return body;
        }
        return Result.success(body);
    }
}
