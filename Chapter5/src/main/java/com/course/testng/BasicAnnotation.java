package com.course.testng;

//import org.testng.annotations.Test;


import org.testng.annotations.*;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static javafx.scene.input.KeyCode.T;

/**
 * Created by test on 2020/5/4.
 */
public class BasicAnnotation{


    @Test
    public void testCase1(){

        System.out.printf("Thread ID: %S%n",Thread.currentThread().getId());
        System.out.println("这是测试用例1");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod");
    }

    @Test
    public void tesCase2(){
        System.out.printf("Thread ID: %S%n",Thread.currentThread().getId());
        System.out.println("这是测试用例2");

    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass");

    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass");

    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");

    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest");

    }

}
