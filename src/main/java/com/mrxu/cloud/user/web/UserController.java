package com.mrxu.cloud.user.web;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ifocusing-xuzhiwei
 * @since 2018/3/7
 */
@RestController
@RequestMapping("/mrxu/user/")
public class UserController {
    @ApiOperation(value = "测试获取", notes = "测试你懂的")
    @RequestMapping(value = {"find"}, method = RequestMethod.POST)
    public String find(){

        return "ok";
    }
}
