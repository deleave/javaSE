package com.内部类;
//成员内部类与外部类没有隐私
//private成员也可互相访问
public class Cow {
    private double weight;

    // 外部类的两个重载的构造器
    public Cow() {
    }

    public Cow(double weight) {
        this.weight = weight;
    }

    // 定义一个成员内部类
    private class CowLeg {
        // 成员内部类的两个实例变量
        private double length;
        private String color;
// 由于成员内部类的实例的创建依赖于外部类的实例的创建，所以成员内部类不可以包含静态成员
        //private static int age;

        // 成员内部类的两个重载的构造方法
        public CowLeg() {
        }

        public CowLeg(double length, String color) {
            this.length = length;
            this.color = color;
        }

        // length、color的setter和getter方法
        public void setLength(double length) {
            this.length = length;
        }

        public double getLength() {
            return this.length;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getColor() {
            return this.color;
        }

        // 成员内部类的方法
        public void info() {
            System.out.println("当前牛腿颜色是：" + color + ", 高：" + length);
            // 直接访问外部类的private修饰的成员变量
//weight引用了创建内部类实例对象的外部类的实例对象的私有数据域。
            System.out.println("本牛腿所在奶牛重：" + weight);
//如果不写Cow.this.，编译器将自动添加
//System.out.println("本牛腿所在奶牛重：" + Cow.this.weight);
        }
    }

    public void test() {
        //CowLeg类的实例对象是在Cow类的实例方法中创建的。
        //所以，在创建CowLeg内部类的实例对象之前，必先创建Cow外部类的实例对象。
        CowLeg cl = new CowLeg(1.12, "黑白相间");
        //如果不写this.编译器将自动添加。
        //CowLeg cl = this.new CowLeg(1.12, "黑白相间");
        cl.info();
    }

    public static void main(String[] args) {
        Cow cow = new Cow(378.9);
        cow.test();
        CowLeg cl = cow.new CowLeg(1.12, "黑白相间");
        System.out.println("本牛腿所在颜色：" +cl.color);	}
//被翻译为以下字节码，说明外部类可以访问成员内部类的私有成员。
// System.out.println("本牛腿所在颜色：" + CowLeg.access$100(cl));
    }
