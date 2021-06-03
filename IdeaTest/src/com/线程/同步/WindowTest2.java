package com.线程.同步;

/**
 *
 * 实现Runnable接口,创建三个窗口卖票
 * 1.重票和错票问题涉及到线程安全问题
 *
 * 2.问题出现的原因：
 * 出现了共享数据，某个线程操作共享数据时，还未完成操作，其他线程也参与进来操作共享数据
 * 3.如何解决： 当一个线程操作共享数据时，
 * 其他线程不能参与进来，直到线程操作完，其他线程才可以操作，即使该线程出现阻塞，也不能改变
 * 4.Java中采用同步机制来解决线程安全问题
 * 方式一：同步代码块
 * synchronized(同步监视器){
 *     //需要被同步的代码
 * }
 * 5. 同步的方式解决了线程安全问题，
 *    局限性:由于操作同步代码时，只能有一个线程参与，其他线程等待，所以最终可以看成一个单线程操作，效率低
 *
 *     补充：在实现Runnable接口创建的多线程中可以用this变量当作同步监视器
 *
 * 说明：1.操作共享数据的代码，即为需要被同步的代码
 *      2.共享数据：多个线程共同操作的数据
 *      3.同步监视器，即为：锁.任何一个类的对象，都可以充当锁
 *        要求：每个线程必须要共用一把锁
 *
 *
 * 方式二：同步方法
 * 如果操作共享数据的同步代码的完整的声明在一个方法中，我们可以将此方法声明为同步方法
 * 1.同步方法仍然涉及到同步监视器,只是不需要我们声明
 * 2.虚方法中,同步监视器是this
 *   静态方法中,同步监视器是:当前类本身
 *
 * @ClassName WindowTest2
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/15 14:04
 * @Version 1.0
 **/

class window2 implements Runnable{
    private int ticket=100;
//    任何一个类的对象，都可以充当锁
    Object obj=new Object();

    @Override
    public void run() {

            while (true) {
                //正确的锁
                synchronized (this) {
//          使线程进入阻塞状态10ms
                if (ticket>0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "买票，票号为：" + ticket);
                    ticket--;
                }else {
                    break;
                }

            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        window2 w1=new window2();

        Thread t1=new Thread(w1);
        Thread t2=new Thread(w1);
        Thread t3=new Thread(w1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }



}
