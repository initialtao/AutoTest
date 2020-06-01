package com.course.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by test on 2020/5/12.
 */
public class ParamterTest{

    @Test
    @Parameters({"name","age"})
    public void paramTest1(String name, int age){
        System.out.print("name=" + name + "\n" + "age=" + age);
    }
}
