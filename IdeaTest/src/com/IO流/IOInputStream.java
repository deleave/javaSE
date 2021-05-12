package com.IO流;

import java.io.*;

public class IOInputStream {
    public static void main(String[] args) throws IOException {
        //DataInputStream类 功能：按照可移植的方式从流读取基本类型（int char string)
        DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream("b.txt")));
        while(dis.available()!=0)
            //注意 read（）是以int类型返回下一字节，必须用char转型
            System.out.println((char) dis.readByte());
        dis.close();
    }
}
