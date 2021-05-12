package com.IO流;
import java.io.*;
public class BufferedInputFile {

    public static String read(String filename) throws IOException{
        //缓冲流较不同输入流小刘更高
        BufferedReader in=new BufferedReader(
                new FileReader(filename)
        );
        String s;
        //StringBuilder对象是一个可变长的String
        //StringBuffer提供的append()、insert()、reverse()、setCharAt()、setLength()等方法可以改变这个字符串对象的字符序列。
        //调用它的toString()方法将其转换为一个String对象。
        StringBuilder sb=new StringBuilder();
        //readLine()方法可以读取一行字符，返回null时就读到了文件末尾
        while ((s=in.readLine())!=null)
            sb.append(s+"\n");
        in.close();
        return sb.toString();
    }

    public static void main(String[] args)throws IOException {
        System.out.println(read("ReplacementsFile"));
    }
}
