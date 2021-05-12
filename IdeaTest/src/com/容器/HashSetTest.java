package com.容器;

import com.IO流.BufferedInputFile;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.io.*;
//Set类不能存相同的元素
public class HashSetTest {
    public static void main(String[] args) throws IOException {
        Set<String> words=new HashSet<>();
        long totalTime=0;
        //分割成字符串数组
        String[] s=BufferedInputFile.read("ReplacementsFile").split(" ");
        //向哈希表中添加元素
        words.addAll(Arrays.asList(s));
        Iterator<String> iter=words.iterator();
        for (int i=0;i<20&&iter.hasNext();i++){
            System.out.println(iter.next());
        }
        System.out.println("...");
        //打印有多少单词
        System.out.println(words.size()+" distinct words.");
        //返回对象的散列码（散列码是为快速查找到对象散列集为每个对象计算的一个整数）
        System.out.println(s.hashCode()+"  ");
    }
}
