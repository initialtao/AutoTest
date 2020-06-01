package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * Created by test on 2020/5/11.
 */
@Test(groups = "teacher")
public class GroupsOnClass3{
    public void teacher1(){
        System.out.println("GroupsOnClass3_teacher1");
    }

    public void teacher2(){
        System.out.println("GroupsOnClass3_teacher2");
    }
}