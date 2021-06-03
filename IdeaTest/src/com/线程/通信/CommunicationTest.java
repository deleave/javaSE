package com.线程.通信;

/**
 *
 * wait():一旦执行此方法,当前线程进入阻塞状态,并会释放自己的锁
 * notify():一旦执行此方法,会唤醒被wait()的一个其他线程,若有多个被wait()阻塞的线程,优先唤醒优先级高的
 * notifyAll():一旦执行此方法,会唤醒被wait()的所有其他线程
 *
 * 说明:
 * 1. wait() 2.notify() 3.notifyAll()只能用于synchronized同步代码块中
 * 2.调用者必须是同步代码块或是同步监视器.否则会出现:IllegalMonitorStateException异常
 * 3.三个方法是Object类中定义的方法
 *
 * 面试题:sleep()与wait()方法的异同
 * 1.相同:一旦执行方法,都会使当前线程进入阻塞状态
 * 2.不同点:1)两个方法声明的位置不同:Thread类中声明sleep,Object类中声明wait()
 *         2)调用的要求不同,sleep可以在需要的场景下调用,wait()必须在同步代码块中或同步方法中调用
 *         3)如果两个方法都使用在同步代码块或同步方法中,sleep()不释放同步监听器,wait()释放
 *
 * @ClassName CommunicationTest
 * @Description 线程通信的例子:使用两个线程打印1-100。线程1，线程2交替打印
 * @Author deleave
 * @Date 2021/5/15 20:44
 * @Version 1.0
 **/
class Number implements Runnable{
    private int number=1;
//    private Object object=new Object();
    @Override
    public void run() {
      while (true) {
          synchronized (this){
//          synchronized (object) {
              //唤醒所有阻塞的线程,只能由同步监听器调用
              notifyAll();
              if (number < 100) {
                  try {
                      Thread.sleep(100);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println(Thread.currentThread().getName() + ":" + number);
                  number++;
                  try {
                      //使得调用如下wait()方法的线程进入阻塞状态,并释放自己的锁
                      wait();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              } else {
                  break;
              }
          }
      }
    }
}
public class CommunicationTest {

    public static void main(String[] args) {
        Number number = new Number();
        Thread t1=new Thread(number);
        Thread t2=new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}
