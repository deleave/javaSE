package com.容器.算法;

import java.util.*;

//二分查找 对数组的查找（高效）
//返回的数值大于等于0，则表示匹配对象的索引，为负则表示为匹配到元素，但可以利用返回值计算应插位置为：-i-1
// 若传入的是链表则采用顺序查找
public class binarySearchTest {
    public static void main(String[] args) {
        //链表二分查找
        List number= new ArrayList(Arrays.asList(11,34,53,23,56,21,56));
        Collections.sort(number);
        System.out.println(number);
       int index1= Collections.binarySearch(number,56);
       int index2=Collections.binarySearch(number,45);
        System.out.println("56所在索引："+index1);
        System.out.println("45所在索引"+index2);
        int insert=-index2-1;
        System.out.println("45应插位置："+insert);

        //数组二分查找
        int[] num={11,34,53,23,56,21,56};
        Arrays.sort(num);
        int index3=Arrays.binarySearch(num,23);
        System.out.println("23所在索引"+index3);
    }
}
