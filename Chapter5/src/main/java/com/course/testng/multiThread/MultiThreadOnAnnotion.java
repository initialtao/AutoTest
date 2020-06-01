package com.course.testng.multiThread;

import org.testng.annotations.Test;

/**
 * Created by test on 2020/5/27.
 */
public class MultiThreadOnAnnotion {

    @Test(invocationCount = 10,threadPoolSize = 5)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread ID: %S%n",Thread.currentThread().getId());
    }
}
