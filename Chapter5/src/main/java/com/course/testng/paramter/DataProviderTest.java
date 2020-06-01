package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by test on 2020/5/27.
 */
public class DataProviderTest {


    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age){
        System.out.println("name=" + name + ",age=" + age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData() {
        Object[][] o = new Object[][]{{"zhangsan", 10}, {"wangwu", 15}, {"zhangsan", 20}};
        return o;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1111方法 ：name=" + name + ",age=" + age );

    }

    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2222方法 ：name=" + name + ",age=" + age );

    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result = null;
        if(method.getName().equals("test1")){
            result=new Object[][]{{"andy",12},{"susuan",15}};
        }
        else if(method.getName().equals("test2")){
            result=new Object[][]{{"eva",31},{"ama",33}};
        }
        return result;
    }



}
