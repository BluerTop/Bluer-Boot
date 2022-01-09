package top.bluer.common.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * @program: bluer-boot
 * @description: 包装返回结果的自定义注解
 * @author: bluer
 * @date: 2021-10-15 15:51
 * codes: 扁鹊
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@RestController
public @interface ResponseResult {
}
