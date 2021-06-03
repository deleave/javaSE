package com.线程.同步;

/**
 *
 * 方式二：同步方法
 *   如果操作共享数据的同步代码的完整的声明在一个方法中，我们可以将此方法声明为同步方法
 * @ClassName WindowTest3
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/15 16:04
 * @Version 1.0
 **/
class window3 implements Runnable{
    private int ticket=100;
    //    任何一个类的对象，都可以充当锁
    Object obj=new Object();

    @Override
    public void run() {

        while (true) {
/*            //正确的锁
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

            }*/
            show();
        }
    }
    public synchronized void show(){
//          使线程进入阻塞状态10ms
                if (ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "买票，票号为：" + ticket);
                    ticket--;
                }

            }
    }

public class WindowTest3 {
    public static void main(String[] args) {
        window3 w1=new window3();

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

