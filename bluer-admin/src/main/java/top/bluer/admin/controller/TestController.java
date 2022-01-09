package top.bluer.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.bluer.common.annotation.ResponseResult;

import java.util.ArrayList;

/**
 * @program: bluer-boot
 * @description: 测试服务
 * @author: bluer
 * @date: 2022-01-09 11:37
 * codes: 扁鹊
 **/
@Api(tags = "测试服务")
@ResponseResult
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "返回布尔值")
    @GetMapping("/boolean")
    public boolean retBool() {
        return true;
    }

    @ApiOperation(value = "返回对象")
    @GetMapping("/object")
    public Object retObject() {
        return new ArrayList<String>() {{
            add("返回对象");
            add("返回对象");
            add("返回对象");
            add("返回对象");
        }};
    }
}
