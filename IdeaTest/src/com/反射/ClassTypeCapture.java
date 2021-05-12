package com.反射;
//由于泛型类型擦除使得 任何在运行时需要知道确切类型信息的操作都将无法工作
//有时必须通过引入类型标签来对擦除进行补偿
//即需要显示的传递你的类型的Class对象，一边你可以在类型表达是中使用它

class Building{}
class House extends Building{}
public class ClassTypeCapture<T> {
    Class<T> kind;
    public ClassTypeCapture(Class<T> kind){
        this.kind=kind;
    }
    public boolean f(Object arg){
        return kind.isInstance(arg);//***判断实例类型是否相同
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1= new ClassTypeCapture<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture<House> ctt2=new ClassTypeCapture<House>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
}
