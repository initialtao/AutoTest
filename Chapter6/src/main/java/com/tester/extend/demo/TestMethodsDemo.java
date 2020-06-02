package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



/**
 * Created by test on 2020/6/1.
 */
public class TestMethodsDemo {

    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void test2(){
        Assert.assertEquals(2,2);
    }

    @Test
    public void test3(){
        Assert.assertEquals(5,5);
    }

    @Test
    public void logDemo(){
        Reporter.log("日志：");
        throw new RuntimeException("我自己运行时异常");
    }


}
