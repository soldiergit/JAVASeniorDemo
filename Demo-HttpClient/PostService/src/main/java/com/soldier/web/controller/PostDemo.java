package com.soldier.web.controller;

import org.springframework.http.MediaType;
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

    /**
     * produces = MediaType.APPLICATION_JSON_VALUE+";charset=UF-8"：解决响应乱码
     */
//    @RequestMapping(value = "/post/param", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE+";charset=UF-8")
    @RequestMapping(value = "/post/param", method = RequestMethod.POST)
    @ResponseBody
    public Object postTestParam(String username, String password) {
        System.out.println(username +"----------------"+password);
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        return map;
    }

}
