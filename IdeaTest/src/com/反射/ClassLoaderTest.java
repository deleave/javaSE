package com.反射;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName ClassLoaderTest
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/16 19:45
 * @Version 1.0
 **/
public class ClassLoaderTest {
    @Test
    public void test1(){
        //获取系统类加载器:主要用于加载自定义为类
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //系统类加载器的上层是扩展类加载器:主要用于加载jre下的lib的ext下的jar包
        ClassLoader classLoaderParent = classLoader.getParent();
        System.out.println(classLoaderParent);

        //系统类加载器的上层是引导类加载器:不能获取.主要加载java的核心类库,无法加载自定义类
        ClassLoader parent = classLoaderParent.getParent();
        System.out.println(parent);

        ClassLoader loader = String.class.getClassLoader();
        System.out.println(loader);
    }

//    Properties:用来获取配置文件
    @Test
    public void test2() throws Exception {
        Properties pros = new Properties();
        //读取配置文件的方式一
        //识别位置要在model下
//        FileInputStream fis = new FileInputStream("src\\jdbc.properties");
//        pros.load(fis);

       //读取配置文件的方式二
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
       //识别位置应在src下
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user="+user+",password="+password);
    }
}
