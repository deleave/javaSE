package com.接口;

import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.math.*;
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets=new String[]{
                "Mercury","Venus","Earth","Mars"
        };
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length");
        Arrays.sort(planets, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(planets));
        Timer t=new Timer(1000,event-> System.out.println("The time is "+new Date()));
        t.start();
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

}
