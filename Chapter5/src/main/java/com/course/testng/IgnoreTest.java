package com.course.testng;

import org.testng.annotations.Test;

/**
 * Created by test on 2020/5/9.
 */
public class IgnoreTest {

    @Test(enabled = false)
    public void ignore1(){
        System.out.println("ignore1");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2");
    }
}
