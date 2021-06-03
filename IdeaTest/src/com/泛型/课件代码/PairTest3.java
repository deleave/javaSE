package com.泛型.课件代码;

import java.util.*;

 class Employee
{
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String n, double s, int year, int month, int day)
    {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public Date getHireDay()
    {
        return hireDay;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
class Manager extends Employee
{
    private double bonus;

    /**
     @param n the employee's name
     @param s the salary
     @param year the hire year
     @param month the hire month
     @param day the hire day
     */
    public Manager(String n, double s, int year, int month, int day)
    {
        super(n, s, year, month, day);
        bonus = 0;
    }

    public double getSalary()
    {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double b)
    {
        bonus = b;
    }

    public double getBonus()
    {
        return bonus;
    }
}


public class PairTest3
{
    public static void main(String[] args)
    {
        Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
        Manager cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 15);
        //Manager cuo = new Manager("Karie Irving",50000, 2003, 12, 15);
        PairDemo<Manager> buddies = new PairDemo<Manager>(ceo,cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);
        Manager[] managers = { ceo, cfo };

        PairDemo<Employee> result = new PairDemo<>();
        minmaxBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName()
                +",salary:"+ result.getFirst().getSalary()
                + ", second: " + result.getSecond().getName()
                +",salary:"+result.getSecond().getSalary());
        maxminBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName()
                +",salary:"+ result.getFirst().getSalary()
                + ", second: " + result.getSecond().getName()
        +",salary:"+result.getSecond().getSalary());
    }

    public static void printBuddies(PairDemo<? extends Employee> p)
    {
        //1、通配符类型的变量可以引用泛型实例化子类的实例
        //	p 可以引用泛型实例化子类Pair<Employee>、Pair<Manager>的实例
        //2、通配符类型的变量可以调用安全的访问器方法。
        //   对于源码：Employee second = p.getSecond();
        //   编译器将取通配符的下界Employee，插入强制类型转换，
        //   生成字节码：Employee second = (Employee)p.getSecond();
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");

        //3、通配符类型的变量不可以调用不安全的更改器方法。
        //   对于源码：p.setFirst(lowlyEmployee);	 //compile-time error
//  原因是，编译器无法在编译时，对输入参数进行强制类型检查，所以error。
//  p 可能引用的是Pair<Manager>类型的实例，
//  那调用的就是Pair<Manager>类型的setFirst方法，将进行Manager强制类型检查；
//  p 也可能引用的是Pair<Employee>类型的实例，
// 那调用的就是Pair<Employee>类型的setFirst方法，将进行Manager强制类型检查；
// 编译时，并没有实例存在，编译器无法判断进行那种强制类型检查，所以error。
//   例如：如果p 引用的是Pair<Manager>类型的实例，p.setFirst(lowlyEmployee)
// 调用的一定是Pair<Manager>类型的方法setFirst，如果实参是Employee类型
// 的实例，可能产生运行时错误。
    }

    public static void minmaxBonus(Manager[] a, PairDemo<? super Manager> result)
    {
        if (a == null || a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++)
        {
            if (min.getBonus() > a[i].getBonus()) min = a[i];
            if (max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager[] a, PairDemo<? super Manager> result)
    {
        minmaxBonus(a, result);
        PairAlg.swapHelper(result); // OK--swapHelper captures wildcard type
        //PairAlg.swap(result);
    }
}
class PairAlg
{
    public static boolean hasNulls(PairDemo<?> p)
    {
        return p.getFirst() == null || p.getSecond() == null;
    }

    // swapHelper方法的T捕获通配符？。
    //通配符捕获只有在很多限制的情况下才是合法的。
    //编译器必须能够确信通配符表达的是单个、确定的类型；
    //逻辑上产生泛型实例化方法
    // public static void <?>swapHelper(Pair<?> p) {……};

    public static void swap(PairDemo<?> p) { swapHelper(p); }

    public static <T> void swapHelper(PairDemo<T> p)
    {
        T t =  p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}

//   //泛型方法擦除类型后，转换的字节码程序
//   public static void swap(PairDemo p) { swapHelper(p); }

//   public static  void swapHelper(PairDemo p)
//   {    t();
//       p.setFirst(p.getSecond());
//       p.setSecond(t);
//   }




