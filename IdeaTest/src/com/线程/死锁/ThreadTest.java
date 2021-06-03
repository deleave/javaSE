package com.线程.死锁;

/**
 * 演示线程的死锁问题
 * 1.死锁的理解:不同的线程分别占用对方需要的同步资源不放弃，
 * 都在等待对方放弃自己需要的同步资源，就形成了线程的死锁
 *
 * 2.说明:
 * 1)出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续
 * 2)我们使用同步时,要避免出现死锁
 * @ClassName ThreadTest
 * @Description 演示线程的死锁问题
 * @Author deleave
 * @Date 2021/5/15 17:21
 * @Version 1.0
 **/
public class ThreadTest {
    public static void main(String[] args) {
        StringBuffer strb1=new StringBuffer();
        StringBuffer strb2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized (strb1) {
                    strb1.append('a');
                    strb2.append('1');

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(strb2){
                        strb1.append('b');
                        strb2.append('2');
                        System.out.println(strb1);
                        System.out.println(strb2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (strb2) {
                    strb1.append('c');
                    strb2.append('3');

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (strb1) {
                        strb1.append('d');
                        strb2.append('4');
                        System.out.println(strb1);
                        System.out.println(strb2);
                    }
                }
        }
    }).start();
}
}

