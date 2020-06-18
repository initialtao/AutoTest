package com.course.httpclient.cookies;

import com.sun.deploy.net.HttpResponse;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by test on 2020/6/11.
 */
public class MyCookiesForGet {

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
    public void testGetWithCookies() throws IOException {

        //获取访问域名
        String uri = bundle.getString("getWithCookies.uri");
        String testurl = this.url + uri;

        System.out.println(testurl);

        HttpGet get = new HttpGet(testurl);

        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();

        CloseableHttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
    }

}
