package top.bluer.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: bluer-boot
 * @description: Knife4jConfig
 * @author: bluer
 * @date: 2022-01-09 11:35
 * codes: 扁鹊
 **/
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class Knife4jConfig {
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("Bluer-Boot 后台接口文档")
                        .description("Bluer-Boot 后台接口文档")
                        .termsOfServiceUrl("https://www.bluer.top")
                        .contact(new Contact("扁鹊", "https://www.bluer.top", "blue9412@aliyun.com"))
                        .version("1.0")
                        .build())
                .groupName("默认版本")
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.bluer"))
                .paths(PathSelectors.any())
                .build();
    }
}
