package com.接口;//【程序 12-2】单个接口的实现---default
//性能:
//接口调用, 多态调用，直接调用所调用的实例方法代码的性能也就显而易见了
//invokeinterface 最慢，invokevitual中，invokespeical最快

//2 实现接口(类--接口的声明继承)
//类—类的实现继承
//2-1 实现单接口---default

//实现接口
public class ImInterfaceDemo implements MyInterface {

    // 定义个一个字符串数组，长度是接口中定义的常量MAX_SIZE
    private String[] msgs = new String[MyInterface.MAX_SIZE];
    // 记录消息个数
    private int num = 0;

    // 实现接口中的方法  virtual new slot
    public void delMsg() {
        if (num <= 0) {
            System.out.println("消息队列已空，删除失败！");
        } else {
            // 删除消息，num数量减1
            msgs[--num] = null;
        }
    }

    // 实现接口中的方法  virtual new slot
    public void addMsg(String msg) {
        if (num >= MyInterface.MAX_SIZE) {
            System.out.println("消息队列已满，添加失败！");
        } else {
            // 将消息添加到字符串数组中，num数量加1
            msgs[num++] = msg;
        }
    }

    // 定义一个实现类自己的方法  virtual new slot
    public void showMsg() {
        // 输出消息队列中的信息
        for (int i = 0; i < num; i++) {
            System.out.println(msgs[i]);
        }
    }

    public static void main(String[] args) {
// 实例化一个接口实现类ImInterfaceDemo的对象，并将其赋值给一个接口变量引用mi
        MyInterface mi = new ImInterfaceDemo();
        ImInterfaceDemo ifd = (ImInterfaceDemo)mi;

        System.out.println("------------------------");
        Class<?> c1 = Object.class;
        System.out.println("Object的父类是："+c1.getSuperclass()); //null

        Class<?> c2 = ImInterfaceDemo.class;
        System.out.println("ImInterfaceDemo的父类是："+c2.getSuperclass());

        Class<?> c3 = MyInterface.class;
        System.out.println("MyInterface的父类是："+c3.getSuperclass());//null

        //物理实现上，接口类型的Superclass为null
        //
        //因为接口类型的变量引用的一定是其实现类的实例，而实现类一定是Object类的派生类
        //所以逻辑上，接口类型继承Object类：
        //mi接口变量可以赋值于Object类的变量
        //Object类的变量一定可以引用其子类的实例对象
        //接口变量可以调用Object类型的实例方法
        //Object类型的实例方法一定可以操作其子类的实例对象
        //System.out.println("接口变量可以赋值于Object类的变量：Object o = mi");
        //Object o = (Object) mi;
        System.out.println("接口变量可以调用Object类型的实例方法："+mi.toString());

        System.out.println("------------------------");
        // 添加信息
        mi.addMsg("我的名字是张珊"); 		//接口类的vtable表中 slot 1
        mi.addMsg("这是一个接口虚方法测试");

        // 输出信息
        ifd.showMsg();						//类的vtable表中 slot 7

        System.out.println("------------------------");
        // 删除一个信息
        ifd.delMsg();						//类的vtable表中 slot 5
        System.out.println("删除一个数据后，剩下的信息是：");

        // 输出信息
        ifd.showMsg();						//类的vtable表中 slot 7

        System.out.println("------------------------");
        // 调用接口的默认方法，默认方法必须通过接口变量所引用的实例对象来调用
        mi.print("张三", "李四", "王五");	//接口类的vtable表中 slot 2

        // 调用接口的静态方法，直接通过“接口名.类方法()”来调用
        System.out.println(MyInterface.staticTest());

        System.out.println("------------------------");
        // 实例化接口实现类
        ifd = new ImInterfaceDemo();

        // 添加信息
        ifd.addMsg("我的名字是李斯");
        ifd.addMsg("这是一个类虚方法测试");

        // 输出信息
        ifd.showMsg();

        System.out.println("------------------------");
        // 删除一个信息
        ifd.delMsg();
        System.out.println("删除一个数据后，剩下的信息是：");

        // 输出信息
        ifd.showMsg();
    }
}

