package com.course.httpclient.demo;

import com.sun.deploy.net.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.Test;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by test on 2020/6/10.
 */
public class MyHttpClient {

    @Test
    public void test1(){

        //用来存放结果
        HttpGet get =new HttpGet("http://localhost:8899/getcookies");
        //HttpClient client = new DefaultHttpClient();
        System.out.println("啦啦啦啦啦啦");
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            CloseableHttpResponse response = client.execute(get);
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            //-- HttpResponse类和EntityUtils类
            System.out.println(result);
        }catch (IOException e){
            System.out.println("呵呵呵呵");
            e.printStackTrace();
        }
        System.out.println("hahhahah");

    }
}
