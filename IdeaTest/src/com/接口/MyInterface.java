package com.接口;//1 定义接口

public interface MyInterface {
    // 接口里定义的成员变量只能是静态常量
    //必须进行初始化
    //命名规范，所有字母大写
    //默认：public static final
    int MAX_SIZE = 50;

    // 接口里定义的普通方法只能是public的抽象方法
    //默认：public abstract  new slot
    void delMsg();

    // 接口里定义的普通方法只能是public的抽象方法
    //默认：public abstract  new slot
    void addMsg(String msg);

    //Java8及其以上版本，允许在接口中定义默认方法
    //可以保证向后兼容
    // 在接口中定义默认方法，需要使用default修饰,带实现的public的虚方法
    //默认：public  new slot
    default void print(String... msgs) {
        for (String msg : msgs) {
            System.out.println(msg);
        }
    }

    //Java8及其以上版本，允许在接口中定义静态方法
    // 在接口中定义静态方法，需要使用static修饰
    //默认：public
    static String staticTest() {
        return "接口里的静态方法";
    }
}








//【程序 12-2】单个接口的实现---default
//性能:
//接口调用, 多态调用，直接调用所调用的实例方法代码的性能也就显而易见了
//invokeinterface 最慢，invokevitual中，invokespeical最快

//2 实现接口(类--接口的声明继承)
//类—类的实现继承
//2-1 实现单接口---default

//实现接口
