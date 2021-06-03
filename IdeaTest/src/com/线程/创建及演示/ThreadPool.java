package com.线程.创建及演示;

import java.util.concurrent.*;

/**
 * 创建线程的方法四:使用线程池
 *
 * 好处:
 * 1.提高响应速度(减少创建线程的时间)
 * 2.降低资源消耗(重复利用线程池中的线程,不需要每次新建线程)
 * 3.便于线程管理
 *   corePoolSize:核心池的大小
 *   maximumPoolSize:最大线程数
 *   keepAliveTime:线程没有任务时最多保持多长时间后会终止
 *
 * @ClassName ThreadPool
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/15 22:32
 * @Version 1.0
 **/
class NumberThread2 implements Runnable{


    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class NumberThread1 implements Runnable{


    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class NumberThread implements Callable {


    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i=0;i<100;i++){
            if (i%2==0){

                System.out.println(Thread.currentThread().getName()+":"+i);
                sum+=i;

            }
        }
        return sum;
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1.new一个可重用的线程池,通过指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //2.执行指定的线程的操作,需要提供实现Runnable接口或Callable接口实现类
        service.execute(new NumberThread2());//适合使用Runnable
        service.execute(new NumberThread1());

        //3.设置属性
//        System.out.println(service.getClass());
        ThreadPoolExecutor service1= (ThreadPoolExecutor) service;
        //调用方法来设置线程池的属性
/*        service1.setCorePoolSize(10);
        service1.setMaximumPoolSize();
        service1.setKeepAliveTime();
        service1.setRejectedExecutionHandler();
        service1.setThreadFactory();*/

        /*
        NumberThread thread = new NumberThread();
        service.submit(thread);//适合使用Callable
        FutureTask task=new FutureTask(thread);
        try {
            Integer o = (Integer) task.get();
            System.out.println("结果为:"+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        //4.关闭连接池
        service.shutdown();
    }
}
