package com.线程.创建及演示;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三:实现Callable接口 ---JDK新增
 *
 * 如何理解实现Callable接口创建多线程,比实现Runnable接口强大
 * 1.call()可以有返回值
 * 2.call()可以抛出异常
 * 3.call()支持泛型
 *
 * @ClassName CallableTest
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/15 22:06
 * @Version 1.0
 **/
//1.创建一个实现Callable的实现类
class NumThread implements Callable<Integer>{
//2.实现Call()方法,将此线程的执行操作放在call()中
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(i);
                 sum += i;
            }
        }
        return sum;
    }
}
public class CallableTest {
    public static void main(String[] args) {
        //3.创建Callable接口的实现类对象
        NumThread t1 = new NumThread();
        //4.将此Callable接口的实现类对象作为参数传递到FutureTask中,创建FutureTask对象
        FutureTask<Integer> futureTask = new FutureTask<>(t1);

        //将FutureTask的对象作为参数传递到Thread类的构造器中,创建Thread对象
        Thread thread = new Thread(futureTask);
        //执行start()方法
        thread.start();

        try {
            //6.获取Callable中call方法的返回值
            //get()方法返回值即为FutureTask构造参数为Callable的实现类,并重写的call()的返回值
            Integer sum = futureTask.get();
            System.out.println("总和为"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
