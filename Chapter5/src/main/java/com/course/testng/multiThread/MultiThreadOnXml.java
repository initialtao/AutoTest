package com.course.testng.multiThread;

import org.testng.annotations.Test;

/**
 * Created by test on 2020/5/28.
 */
public class MultiThreadOnXml {

    @Test
    public void test1(){
        System.out.println(1);
        System.out.printf("Thread ID: %S%n",Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.println(2);
        System.out.printf("Thread ID: %S%n",Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.println(3);
        System.out.printf("Thread ID: %S%n",Thread.currentThread().getId());
    }

}
