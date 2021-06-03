package com.线程.同步;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 解决线程安全问题的方式三:Lock锁 ---JDK5.0新增
 *
 * 1.面试题：synchronized与lock的异同？
 * 同:二者都可以解决线程安全问题
 * 不同:synchronized机制执行完相应的同步代码后,自动的释放同步监听器
 *     lock需要手动的启动(lock()),同时结束同步也要手动的实现(unlock())
 *
 * 面试题:如何解决线程安全问题?有几种方式?
 * 三种 Lock->同步代码块->同步方法
 *
 * @ClassName LockTest
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/15 17:58
 * @Version 1.0
 **/
class WindowLock implements Runnable{
    private int ticket=100;

    //fair:true 线程先进先出
    //1.实例化ReentrantLock
    private ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                //2.调用lock()方法
                lock.lock();
                if (ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"买票,票号为:"+ticket);
                    ticket--;
                }else {
                    break;
                }
            } finally {
                //3.调用解锁的方法
                lock.unlock();
            }
        }
    }
   }
public class LockTest {
    public static void main(String[] args) {

        WindowLock w1 = new WindowLock();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
