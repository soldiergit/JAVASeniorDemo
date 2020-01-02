package com.soldier.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName:JAVA-Senior-Demo
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:20-1-2下午4:35
 * @Describe:
 **/
@Controller
@RequestMapping("/test")
public class PostDemo {

    /**
     * ResponseBody是让springMVC对map作json格式的数据转换
     */
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public Object postTest() {
        Map<String, String> map = new HashMap<>();
        map.put("msg", "Test Ok!!!");
        return map;
    }
}
