package top.bluer.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.bluer.common.interceptor.ResponseResultInterceptor;

/**
 * @program: bluer-boot
 * @description: WebMvc配置类拦截器注册者添加返回结果拦截器
 * @author: bluer
 * @date: 2021-10-15 16:09
 * codes: 扁鹊
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 添加自定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ResponseResultInterceptor()).addPathPatterns("/**");
    }
}
