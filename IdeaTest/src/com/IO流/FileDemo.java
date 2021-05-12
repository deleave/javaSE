package com.IO流;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        try {
            File file=new File("D:\\Dev\\steam\\c.txt");
            System.out.println("是否存在该文件或目录："+file.exists());
            System.out.println("是否是文件："+file.isFile());
            System.out.println("是否创建了新文件："+file.createNewFile());//创建不加路径的文件或已有路径的文件，不可创建新路径的文件
            System.out.println("绝对路径："+file.getAbsolutePath()+"\n文件名： "+file.getName()+"\n路径："+file.getPath());
            System.out.println("是否删除文件或目录:"+file.delete());
            File file1=new File("D:\\Dev");
            System.out.println("是否为目录："+file1.isDirectory());
            //System.out.println("是否创建完全目录："+file1.mkdirs()+"\n是否创建一级目录："+file1.mkdir());
            String[] names= file1.list();
            for (String name:names
                 ) {
                System.out.println("String目录："+name);
            }
            File[] files=file1.listFiles();
            for (File f:files
                 ) {
                System.out.println("File数组目录："+f);
            }


        } catch (FileNotFoundException e) {
            //抓取到的是编译期异常  抛出去的是运行期
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
        System.out.println("over");
    }
}



