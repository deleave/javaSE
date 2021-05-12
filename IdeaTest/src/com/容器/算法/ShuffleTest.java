package com.容器.算法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleTest {
    public static void main(String[] args) {
        List<Integer> numbers=new ArrayList<>();
        for (int i=0;i<50;i++){
            numbers.add(i+3);
        }
        Collections.shuffle(numbers);//混排列表中的元素
        List<Integer> winningCombination=numbers.subList(0,6);//选出子列表传入新的List
        System.out.println("选出混排的六个元素："+winningCombination);
        Collections.sort(winningCombination);//排序列表中的元素
        System.out.println("排序后："+winningCombination);
    }
}
