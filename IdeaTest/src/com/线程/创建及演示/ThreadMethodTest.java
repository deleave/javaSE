package com.线程.创建及演示;

/**
 * 测试Thread中的常用方法
 * 1.start():启动当前线程，调用run()
 * 2.run():通常需要重写Thread类中的次方法，创建的线程要执行的操作声明再此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName()：获取当前线程的名字
 * 5.setName()：设置当前线程的名字
 * 6.yield():释放当前cpu的执行权
 * 7.join()：在线程a中调用线程b的join(),此时线程a就进入阻塞状态，知道线程b完全执行完以后线程a才结束阻塞状态。
 * 8.stop():强制结束线程
 * 9.sleep(long millis):是线程进入阻塞状态指定的毫秒数。在指定的毫秒内，当前线程处于阻塞状态。
 * 10.isAlive():判断当前线程是否存活
 *
 *
 *线程的优先级：
 * MAX_PRIORITY: 10
 * MIN_PRIORITY: 1
 * NORM_PRIORITY: 5
 * 2.如何获取和设置当前线程的优先级
 * getPriority();
 * setPriority();
 *
 * 说明：高优先级的线程执行的概率高，并不意味着先高后低
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
/*                try {
                    //使线程睡眠 1s
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
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

        //设置分线程的优先级
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        s1.start();

        Thread.currentThread().setName("主线程");
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
            }
            if (i==20){
/*                try {
                  //调用线程s1“插队” 开始执行线程一，主线程进入阻塞状态
                   s1.join();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }*/
            }

        }
    }
}
