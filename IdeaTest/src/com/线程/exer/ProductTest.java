package com.线程.exer;

/**
 *
 * 线程通信的应用:经典例题:生产者/消费者问题
 * 生产者(Productor)将产品交给店员(Clerk)由店员卖出产品，而消费者(Customer)从店员处购买产品，店员一次只能持有固定数量的产品(比如:20)，
 * 如果生产者试图生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产;
 * 如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 *
 * 分析:
 * 1.是否是多线程问题?是,生产者线程,消费者线程
 * 2.是否有共享数据?是,产品(或店员)
 * 3.如何解决线程安全问题? 同步机制,三种方法 Lock->synchronized同步代码块->同步方法
 * 4.是否涉及到线程的通信?是
 *
 *
 * @ClassName ProductTest
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/15 21:15
 * @Version 1.0
 **/
class Clerk{
    private int productCount=0;

    //进货
    public synchronized void producerProduct() {
        if (productCount<20){
            notifyAll();
            productCount++;
            System.out.println(Thread.currentThread().getName()+"发货第"+productCount+"个产品");
            //货太多了,慢点进货
            if (productCount>10){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else {
            //等待卖出
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //卖出
    public synchronized void consumProduct() {
        if (productCount>0){
            System.out.println(Thread.currentThread().getName()+"消费第"+productCount+"产品");
            productCount--;
            notifyAll();
        }else {
            //等待进货
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Product extends Thread{
    private Clerk clerk;

    public Product(Clerk clerk){
        this.clerk=clerk;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":开始进货产品");

        while (true){
            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.producerProduct();
        }
    }
}
class Custom extends Thread{
    private Clerk clerk;

    public Custom(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":开始卖出产品");

        while (true){

            try {
                sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumProduct();
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Product product = new Product(clerk);
        Custom custom = new Custom(clerk);
        Custom custom2 = new Custom(clerk);
        product.setName("生产者1");
        custom.setName("消费者1");
        custom2.setName("消费者2");

        product.start();
        custom.start();
        custom.start();

    }
}
