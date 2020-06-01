package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * Created by test on 2020/5/11.
 */

@Test(groups = "Stu")
public class GroupsOnClass1 {

    public void stu1(){
        System.out.println("GroupsOnClass1_stu1");
    }

    public void stu2(){
        System.out.println("GroupsOnClass1_stu2");
    }
}
