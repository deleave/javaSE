package com.线程.exer;

/**
 * @ClassName ThreadDemo
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/11 21:34
 * @Version 1.0
 **/
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    if (i%2==0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    if (i%2!=0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();
    }
}
