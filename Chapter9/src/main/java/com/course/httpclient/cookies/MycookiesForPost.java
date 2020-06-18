package com.course.httpclient.cookies;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;
import static javafx.scene.input.KeyCode.J;

/**
 * Created by test on 2020/6/15.
 */
public class MycookiesForPost {

    private String url;
    //用于读取配置文件的变量
    private ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);
    private CookieStore cookieStore = new BasicCookieStore();

    @BeforeTest
    //测试前先读取配置文件
    public void beforeTest(){
        //配置文件赋给bundle
        //bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        //获取配置文件(bundle)的值，括号里面为key
        this.url= bundle.getString("test.url");//可通过这个值切换环境
    }

    @Test
    public void testGetCookies(){
        //获取访问域名
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url+uri;
        System.out.println(testUrl);

        HttpGet get = new HttpGet(testUrl);
        try{
            //创建请求 并且获取cookie
            //CloseableHttpClient client =  HttpClients.createDefault();
            CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();
            //连接请求
            CloseableHttpResponse response = client.execute(get);
            response.
            //将请求返回结果变成String类型
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);

            //读取cookie
            List<Cookie> cookielist = cookieStore.getCookies();
            for(Cookie cookie: cookielist){
                String name=cookie.getName();
                String value=cookie.getValue();
                System.out.println("cookie name =" + name);
                System.out.println("Cookie value=" + value);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostWithCookie() throws IOException{

        //获取访问域名
        String uri = bundle.getString("postWithCookies.uri");
        String testurl = this.url + uri;
        System.out.println(testurl);

        HttpPost post = new HttpPost(testurl);

        //添加头信息
        //post.setHeader("content-type","application/json");

        //添加json对象，设置参数
        JSONObject param = new JSONObject();
        param.put("name","zhangshan");
        param.put("age","18");
        //将参数添加到方法里面
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        // 设置cookie，执行post方法
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();
        //获取返回结果
        CloseableHttpResponse response = client.execute(post);

        //将返回结果转化为string类型

        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        //将string类型转化为json对象
        JSONObject resultjson = new JSONObject(result);
        String zhangsan =(String)resultjson.get("zhangsan");


        String status = (String)resultjson.get("status");

        Assert.assertEquals("success",zhangsan);
        Assert.assertEquals("1",status);
    }


}
