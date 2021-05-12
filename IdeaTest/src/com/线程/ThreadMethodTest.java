package com.线程;

/**
 * 测试Thread中的常用方法
 * 1.start():启动当前线程，调用run()
 * 2.run():通常需要重写Thread类中的次方法，创建的线程要执行的操作声明再此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName()：获取当前线程的名字
 * 5.setName()：设置当前线程的名字
 * 6.yield():释放当前cpu的执行权
 * @ClassName ThreadMethodTest
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/11 21:42
 * @Version 1.0
 **/

class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            if (i%10==0){
                yield();
            }
        }
    }
}
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread s1=new HelloThread();
        s1.setName("线程一");
        s1.start();
        Thread.currentThread().setName("主线程");
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            if (i==20){
                try {
                    s1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
