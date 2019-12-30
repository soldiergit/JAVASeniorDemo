package com.soldier.web.controller;

import com.soldier.commons.JsonUtils;
import com.soldier.pojo.Users;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:JAVA-Senior-Demo
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:19-12-30下午5:30
 * @Describe:拦截用户操作
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * jquery同域请求
     * ResponseBody:不跳转,原页面响应
     */
    @RequestMapping("/findUser")
    @ResponseBody
    public Object findUser() {

        List<Users> usersList = this.addData();

        return usersList;
    }

    /**
     * jsonp使用ajax跨域请求
     * 参数名必须与ajax中jsonp的值一致
     * 返回结果不能是对象,必须是json字符串
     * 而且返回数据格式必须为:callback+"("+json+")"
     *      即:ajax中jsonp的值+"("+对象的json串+")"
     *      即:callback({id:1,name:zhangsan...})
     */
    @RequestMapping("/jsonpFindUser")
    @ResponseBody
    public String jsonpFindUser(String callback) {
        List<Users> usersList = this.addData();

        //  转为json串
        String json = JsonUtils.objectToJson(usersList);

        // ajax中jsonp的值+"("+对象的json串+")"
        return callback+"("+json+")";
    }

    /**
     * jsonp使用ajax跨域请求
     *      SpringMVC 对 JsonP 的支持
     */
    @RequestMapping("/jsonpFindUser2")
    @ResponseBody
    public Object jsonpFindUser2(String callback) {
        List<Users> usersList = this.addData();

        //  转为json串--不再需要自己的JsonUtils
        MappingJacksonValue jacksonValue = new MappingJacksonValue(usersList);
        jacksonValue.setJsonpFunction(callback);

        return jacksonValue;
    }

    private List<Users> addData() {
        Users users1 = new Users(1, "zhangsan", 20);
        Users users2 = new Users(2, "lisi", 20);
        Users users3 = new Users(3, "wangwu", 20);

        List<Users> usersList = new ArrayList<Users>();
        usersList.add(users1);
        usersList.add(users2);
        usersList.add(users3);
        return usersList;
    }
}
