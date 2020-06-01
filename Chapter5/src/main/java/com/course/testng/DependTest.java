package com.course.testng;

import org.testng.annotations.Test;

/**
 * Created by test on 2020/5/12.
 */
public class DependTest {

    @Test
    public void test1(){
        System.out.println("tes1 run");
        //throw new RuntimeException();

    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("tes2 run");
    }
}
