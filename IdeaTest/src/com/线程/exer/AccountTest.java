package com.线程.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户。
 *有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 *
 * 分析:
 * 1.是否是多线程问题? 是,两个储户线程
 * 2.是否共享数据? 有,账户
 * 3.是否有线程安全问题? 有,两个储户同时操作账户
 * 4.需要考虑如何解决安全问题?同步机制:有三种方式
 * @ClassName AccountTest
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/15 20:19
 * @Version 1.0
 **/
class Account{

    private Double balance=0.0;

    public Account(Double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public  void deposit(double amt){

        if (amt>0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance+=amt;
            System.out.println(Thread.currentThread().getName()+"存钱成功,余额为:"+balance);
        }
    }
}
class Customer implements Runnable{
    private Account acct;

   private ReentrantLock lock= new ReentrantLock();
    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {

        for (int i=0;i<3;i++){
            try {
                lock.lock();
                acct.deposit(1000);
            }finally {
                lock.unlock();
            }

        }

    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account acct=new Account();
        Customer c=new Customer(acct);

        Thread t1=new Thread(c);
        Thread t2=new Thread(c);
        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();
    }



}
