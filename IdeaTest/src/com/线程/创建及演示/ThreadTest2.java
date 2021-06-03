package com.线程.创建及演示;

/**
 * 创建多线程的方式二:实现Runnable接口
 * 1.创建一个实现了Runnable的类
 * 2.实现类实现run()方法
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()方法
 *
 *比较创建线程的两种方式
 * 开发中优先选择：实现Runnable接口的方式
 * 原因：1.实现的方式没有类的单继承的局限性
 *      2.实现的方式更适合来处理多个线程有共享数据的情况
 *
 * 联系：public class Thread implements Runnable
 * Thread类也实现的Runnable接口的run方法
 * 相同点：两种方式都需要重写run方法，将执行的逻辑声明在run方法中。
 * @ClassName ThreadTest2
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/14 21:25
 * @Version 1.0
 **/
// 1.创建一个实现了Runnable的类
class RThread implements Runnable {
//    2.实现类实现run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadTest2 {
    public static void main(String[] args) {
//        3.创建实现类的对象
        RThread thread = new RThread();
//        4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t = new Thread(thread);
//        5.通过Thread类的对象调用start()方法:1.启动线程2.调用当前线程的run()-->调用了Runnable类型的target
        t.start();

        //再启动一个线程，遍历100内的偶数
        Thread t1 = new Thread(thread);
        t1.start();
    }
}
