package com.IO流;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamConstruct {

        public static void main(String[] args) throws IOException {
            // 使用File对象创建流对象
            File file = new File("D:\\Dev\\a.txt");
            FileOutputStream fos = new FileOutputStream(file);//与creatNewFile()方法相同，不能创建无确定路径的文件

            // 使用文件名称创建流对象
           // FileOutputStream fos1 = new FileOutputStream("b.txt");//不写路径也可创建到java项目文件中
            //不追加数据
            FileOutputStream fos3=new FileOutputStream("b.txt",false);
            byte[] bytes1="abstract".getBytes();
            fos3.write(bytes1);
            //追加数据构造方法
            FileOutputStream fos2=new FileOutputStream("b.txt",true);
            byte[] bytes="bstract".getBytes();
                fos2.write(bytes);
                fos2.close();



        }
    }


