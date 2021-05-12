package com.容器;
//类型安全的容器——ArrayList
import java.util.ArrayList;

public class Gerbil {
    private static long counter;
    private  int gerbilNumber;
    Gerbil(){
        gerbilNumber=10;
    }
    public void hop(){
        System.out.println("Gerbil counter "+counter);
        counter++;
    }

    public static void main(String[] args) {
        ArrayList gerbils=new ArrayList();
        for(int i=0;i<10;i++){
            gerbils.add(new Gerbil());
        }
        for(int i=0;i<gerbils.size();i++){
            ((Gerbil)gerbils.get(i)).hop();
            System.out.println((Gerbil)gerbils.get(i));
        }
        gerbils.add(new Gerbil());
        System.out.println(((Gerbil)gerbils.get(gerbils.size()-1)).gerbilNumber);
    }
}
