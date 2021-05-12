package com.容器;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<String,Item> itemMap=new HashMap<>();
        itemMap.put("1",new Item("Amy",11));
        itemMap.put("278",new Item("Rachel",13));
        itemMap.put("421",new Item("Harry",12));
//        System.out.println("链接散列映射键："+itemMap.keySet().iterator());
        System.out.println("输出所有键值：\n"+itemMap);
        itemMap.remove("1");
        System.out.println("删除键为1的值后：\n"+itemMap);
        //改变键为278的值
        itemMap.put("278",new Item("Gray Cooper",16));
        System.out.println("获取建为421的值：\n"+itemMap.get("421"));
        System.out.println("输出所有键值对：");
        //访问所有所有映射条目最高效方法
        itemMap.forEach((k,v)->
        System.out.println("key="+k+",value="+v));
        //第二种遍历键值对方法
        for (Map.Entry<String, Item> entry: itemMap.entrySet()
             ) {
            String k=entry.getKey();
            Item v= entry.getValue();
            System.out.println("key= "+k+", value="+v);
        }

    }
}
