package com.异常;
import java.io.FileNotFoundException;

//try{
//        编写可能会出现异常的代码
//        }catch(异常类型A  e){  当try中出现A类型异常,就用该catch来捕获.
//        处理异常的代码
//        //记录日志/打印异常信息/继续抛出异常
//        }catch(异常类型B  e){  当try中出现B类型异常,就用该catch来捕获.
//        处理异常的代码
//        //记录日志/打印异常信息/继续抛出异常
//        }

public class TryCatchDemo4 {
    public static void main(String[] args) {
        try {
            read("a.txt");
        } catch (FileNotFoundException e) {
            //抓取到的是编译期异常  抛出去的是运行期
            throw new RuntimeException(e);
        } finally {
            System.out.println("不管程序怎样，这里都将会被执行。");
        }
        System.out.println("over");
    }
    /*
     *
     * 我们 当前的这个方法中 有异常  有编译期异常
     */
    public static void read(String path) throws FileNotFoundException {
        if (!path.equals("a.txt")) {//如果不是 a.txt这个文件
            // 我假设  如果不是 a.txt 认为 该文件不存在 是一个错误 也就是异常  throw
            throw new FileNotFoundException("文件不存在");
        }
    }
}

