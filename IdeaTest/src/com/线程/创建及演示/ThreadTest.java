package com.线程.创建及演示;

/**
 * @ClassName ThreadTest
 * @Description 多线程的创建
 * @Author deleave
 * @Date 2021/5/11 20:55
 * @Version 1.0
 **/
/*
*多线程的创建，方式一：继承Thread类
* 1.创建一个继承于Thread类的子类
* 2.重写Thread类的run()方法-->将此线程执行的操作声明在run()中
* 3.创建Thread类的子类对象
* 4.通过此对象调用start()
*
*
*
* 例子：遍历100以内的所有偶数
* */
//    1.创建一个继承于Thread类的子类
    class MyThread extends Thread{
//        2.重写Thread类的run()方法

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

//    1.创建一个继承于Thread类的子类
class MyThread2 extends Thread{
//        2.重写Thread类的run()方法

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
    public class ThreadTest {
        public static void main(String[] args) {
//            3.创建Thread类的子类对象
            MyThread t1 = new MyThread();
//            4.通过此对象调用start():1。启动当前线程，2.调用当前线程的run（）方法
            t1.start();
//            t1.run();//问题一：我们不能通过直接调用run()的方式启动线程
            //问题二：不能再启动一个线程去调用start()去执行，会有IllegalThreadStateException异常
            MyThread t2 = new MyThread();//可以new一个新线程对象MyThread2
            t2.start();
//=========以上步骤是由主线程帮忙创建Thread类的子类对象并调用start()方法=======================
            //主线程与MyThread同时执行
            for (int i=0;i<100;i++){
                if (i%2!=0){
                    System.out.println("main"+i);
                }
            }
        }

    }
