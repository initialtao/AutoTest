package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.remoting.rmi.CodebaseAwareObjectInputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import static com.sun.xml.internal.ws.api.message.Packet.Status.Request;

/**
 * Created by test on 2020/6/17.
 */
@RestController
@Api(value = "/",description = "全部的post方法")
//@RequestMapping("v1")
public class MyPostMethod {

    //这个变量装cookie信息
    private static Cookie cookie;

    @ApiOperation(value = "登录接口，成功后返回cookie",httpMethod = "POST")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName",required = true) String userName,
                        @RequestParam(value = "password",required = true )String password){
        if(userName.equals("tyq")&& password.equals("123")){
            cookie = new Cookie("loginname","true");
            response.addCookie(cookie);
            return "恭喜登录成功";
        }
        else return "用户名或者密码错误";

    }
}
