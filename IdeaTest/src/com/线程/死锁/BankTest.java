package com.线程.死锁;

/**
 * @ClassName BankTest
 * @Description 使用同步机制将单例模式中的懒汉式改写为线程安全的
 * @Author deleave
 * @Date 2021/5/15 16:50
 * @Version 1.0
 **/
public class BankTest {
}
//单例模式
class Bank {
    private Bank() {
    }

//    volatile 关键字（用来修饰被不同线程访问和修改的变量）
    private static volatile Bank instance = null;

    public static Bank getInstance() {
        //方式一:效率差,只有一个instance,
        // 被返回后其他线程进入synchronized没用
/*        synchronized (Bank.class) {
            if (instance == null) {
                instance = new Bank();

            }
            return instance;
        }*/
        //方式二:效率更高 若instance已生成,其他线程不必重写执行synchronized代码块
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();

                }
            }

        }
        return instance;
    }
}