package com;
//类的关系——关联
//重写toString()方法，方便输出对象
class Car {
    private String car;
  void run(String city) {
        System.out.println("汽车开到" + city);
    }
    public String toString(){
       return  "Car"+car;
    }

}

class Person {
    // Car对象作为成员变量
    Car car;
    private String Person;

    Person(Car car) {
        this.car = car;
    }

    void travel() {
        car.run("青岛");
    }
    public String toString(){
        return "Person="+Person+" ";

    }
}

public class AssociationDemo {

    public static void main(String[] args) {
        Car car = new Car();
        Person p = new Person(car);
        p.travel();
        System.out.println(p);
        System.out.println(car);
        // new Person(new Car()).travel();
    }

}
