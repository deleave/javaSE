package com.线程.同步;

/**
 *
 * 使用同步方法的方式处理数据同步
 *
 *
 * @ClassName WindowTest4
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/15 16:12
 * @Version 1.0
 **/
class window4 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
            }
        }
        private static synchronized void show(){//同步监视器:Window4.class
            if (ticket > 0) {
                //          使线程进入阻塞状态10ms
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "买票，票号为：" + ticket);
                ticket--;
            }
        }
    }


public class WindowTest4 {
    public static void main(String[] args) {

        window4 w1=new window4();
        window4 w2=new window4();
        window4 w3=new window4();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }



}
