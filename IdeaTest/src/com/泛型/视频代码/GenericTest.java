package com.泛型.视频代码;


import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 * 1.jdk 5.0的新特性
 *
 * 2.在集合里使用泛型
 * 总结:
 * 1)集合接口或集合类在jdk5.0后都修改为带泛型的结构
 * 2)在实例化集合类时,可以指明具体的类的泛型类型
 * 3)指明以后,传入类型参数T被代替为传入的类型参数
 * 4)注意:泛型的类型必须为类,不能为基本数据类型(如 int),要传入包装类
 * 5)实例化时没有指明泛型的类型,默认类型为Object类型
 * @ClassName GenericTest
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/16 16:52
 * @Version 1.0
 **/
public class GenericTest {

    //使用泛型的集合的遍历
    @Test
    public void test1(){
        ArrayList<Integer> list=new ArrayList<>();

        list.add(13);
        list.add(43);
        list.add(33);
        list.add(63);

  /*      for (Integer score:list){
            int stuScore=score;
            System.out.println(stuScore);
        }*/

//        遍历方式二:Iterator
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer stuScore = iterator.next();
            System.out.println(stuScore);
        }

    }

    @Test
    public void test2(){
        Map<String,Integer> map=new HashMap<>();
        map.put("Rachel",45);
        map.put("Jack",95);
        map.put("Trunk",85);
//       map的遍历
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key+"--->"+value);
        }
    }


}
