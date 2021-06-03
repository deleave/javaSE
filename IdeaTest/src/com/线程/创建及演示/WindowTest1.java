package com.线程.创建及演示;

/**
 *
 * 实现Runnable接口,创建三个窗口卖票
 * 重票问题涉及到线程安全问题，待解决
 * @ClassName WindowTest2
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/15 14:04
 * @Version 1.0
 **/

 class window1 implements Runnable{
    private int ticket=100;

    @Override
    public void run() {
        while (ticket>0){
            System.out.println(Thread.currentThread().getName()+":买票，票号为："+ticket);
            ticket--;
        }
    }
}
public class WindowTest1 {
    public static void main(String[] args) {
        window1 w1=new window1();

        Thread t1=new Thread(w1);
        Thread t2=new Thread(w1);
        Thread t3=new Thread(w1);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }



}
