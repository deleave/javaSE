package com.线程.同步;

/**
 *
 * 例子：创建三个窗口卖票
 *
 * @ClassName windowTest
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/14 21:01
 * @Version 1.0
 **/
class window extends Thread {
    private static int ticket = 100;
    static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //不正确的锁，每个线程都有一个锁
//            synchronized (this) {
//            在继承Thread类的实现方法中，不能用this当做锁，但可以用this.getClass()当作锁
//            类也是一个唯一的对象
            synchronized (this.getClass()){
//          使线程进入阻塞状态10ms
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "买票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class windowTest1 {
    public static void main(String[] args) {

        window w1=new window();
        window w2=new window();
        window w3=new window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }



}
