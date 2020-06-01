package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * Created by test on 2020/5/9.
 */
public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("server组的测试1");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("server组的测试2");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("client测试1");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("client测试2");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("server组之前运行");

    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("server组之后运行");

    }

    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("client组之前运行");

    }

    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("client组之后运行");

    }

}
