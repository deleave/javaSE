package com.itheima;
 enum Note{
    MIDDLE,BIG,SMALL,
}
class Cycle{
    public  void ride(Note s)
    {
        System.out.println("Cycle.ride() :"+s+" ");
    }
}
class Bicycle extends Cycle{
    public void ride(Note s)
    {
        System.out.println("Bicycle.ride() :"+s+" ");
    }
}
class Unicycle extends Cycle{
     public void ride(Note s){
         System.out.println("Unicycle.ride() :"+s+" ");
     }
}
class Tricycle extends Cycle{
     public void ride(Note s){
         System.out.println("Tricycle.ride() :"+s+" ");
     }
}
public class pra_多态 {
     public static void tune(Cycle i){
         i.ride(Note.MIDDLE);
     }
     public static void tune2(Cycle i){
         i.ride(Note.BIG);
     }

    public static void main(String[] args) {
        Bicycle bicycle=new Bicycle();
        Unicycle unicycle=new Unicycle();
        Tricycle tricycle=new Tricycle();
        tune(bicycle);
        tune(unicycle);
        tune2(tricycle);

    }
}
