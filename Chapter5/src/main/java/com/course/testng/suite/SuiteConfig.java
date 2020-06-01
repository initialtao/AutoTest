package com.course.testng.suite;

import org.testng.annotations.*;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * Created by test on 2020/5/8.
 */
public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.print("afterSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");

    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest");

    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");

    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");

    }


}
