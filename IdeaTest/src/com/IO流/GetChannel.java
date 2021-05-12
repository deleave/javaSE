package com.IO流;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class GetChannel {
    public static final int BSIZE=1024;

    public static void main(String[] args) throws IOException {
        //写入一个文件
        FileChannel fc=new FileOutputStream("data.txt").getChannel();
        //调用wrap()将已存在的字节数组包装到ByteBuffer中
        fc.write(ByteBuffer.wrap("Some text".getBytes(StandardCharsets.UTF_8)));
        fc.close();
        //将FileChannel移动至文件尾部
        fc=new RandomAccessFile("data.txt","rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        //读出文件内容
        fc=new FileInputStream("data.txt").getChannel();
        //调用allocate()来分配ByteBuffer缓冲器
        ByteBuffer buffer=ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        //让缓冲器做好被别人读取字节的准备
        buffer.flip();
        while (buffer.hasRemaining())
            System.out.println((char)buffer.get() );
        fc.close();
    }
}
