package com.course.testng;

import org.testng.annotations.Test;

/**
 * Created by test on 2020/5/11.
 */
public class ExpectedException {
    /*在期望结果为某个异常
    比如：传入了某些不合法的参数，程序抛出异常
    预期结果就是这个异常
     */
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是一个异常测试");
        throw new RuntimeException();
        /*抛出异常后，下一行代码一定运行不到*/
    }
}
