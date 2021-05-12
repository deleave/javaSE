package com.IO流;
import java.io.*;
public class UsingRandomAccessFile {
    static String file="RandomFile.txt";
    static void display() throws IOException {
        //构造只读对象
        RandomAccessFile raf=new RandomAccessFile(file,"r");
        for(int i=0;i<7;i++){
            //读出Double类型数据
            System.out.println("Value "+i+": "+raf.readDouble());
        }
        //读出String字符串并且该字符串采用UTF-8编码
        System.out.println(raf.readUTF());
        raf.close();
    }

    public static void main(String[] args) throws IOException {
        //构造读写对象
        RandomAccessFile rf=new RandomAccessFile(file,"rw");
        for (int i=0;i<7;i++)
            //写入数据
            rf.writeDouble(i*3.414);
        rf.writeUTF("文件尾");
        rf.close();
        //打印数据
        display();
        rf=new RandomAccessFile(file,"rw");
        //按字节查找数据 double数据占8字节长 查找第五个双精度值
        rf.seek(5*8);
        //修改该双精度值
        rf.writeDouble(57.23400);
        rf.close();
        display();
    }
}
