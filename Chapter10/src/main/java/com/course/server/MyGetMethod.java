package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;
import static javafx.scene.input.KeyCode.R;

/**
 * Created by test on 2020/6/15.
 */
//告诉ComponentScan，我是需要被扫描的类
@RestController
@Api(value = "/",description = "全部的get方法")
public class MyGetMethod {

    //访问get，返回cookie
    //说明访问路径

    @ApiOperation(value = "通过该方法获取cookie",httpMethod = "GET")
    @RequestMapping(value = "/getcookies",method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){

        //装请求信息的类 HttpServerletRequest
        ///装响应信息的类HttpServerletResponse
        Cookie cookie = new Cookie("loginname","ture");
        System.out.print(cookie);
        response.addCookie(cookie);
        return "恭喜获得cookies";
    }

    /**
     * 需要携带cookie访问的get接口开发
     */

    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value = "必须携带cookie才能访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){

        Cookie[] cookielist = request.getCookies();
        if(Objects.isNull(cookielist)){
            return "你需要携带cookie";
        }
        else{
            for (Cookie cookie:cookielist){
                if (cookie.getName().equals("loginname")&&cookie.getValue().equals("true")) {
                    return "cookie正确，访问成功";
                }
                else{
                    return "cookie错误，访问失败";
                }
            }
            return "已经携带了cookie";
        }
    }

    /**需要携带cookie访问的get接口开发
     * 第一种实现方式url :key=value&key=value
     * 模拟获取商品列表的接口
     */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "必须携带参数才能访问的方法一",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("桃子",20);
        myList.put("衬衫",120);

        return myList;
    }

    /**
     * 第二种需要携带参数访问的get请求
     * url：ip：port /get/with/param/10/20
     */
    @RequestMapping(value = "/get/with/param/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "必须携带参数才能访问的方法二",httpMethod = "GET")
    public Map<String,Integer> getListTwo(@PathVariable Integer start, @PathVariable Integer end){

        Map<String,Integer> myList = new HashMap<>();
        myList.put("可乐",3);
        myList.put("薯片",6);

        return myList;
    }
}


