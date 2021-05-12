package com.容器;

import java.util.*;

//Arrays与Collection添加一组元素
//Arrays.asList()与Collections.addAll()使用方法
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection=
                new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInts={6,7,8,9,10};
        collection.addAll(Arrays.asList(moreInts));//运行效率慢
        //更好的使用collections.addAll()的方法
        Collections.addAll(collection,11,12,13,14,15);
        Collections.addAll(collection,moreInts);
       // Arrays.asList()方法
        /*注意：使用Arrays.asList()构造的List底层实现是用数组实现的
        只要你执行的操作会修改这个List,那么就会会改变原先的List
        所以，你应该在另一个容器中创建一个副本
        */
        List<Integer> list= Arrays.asList(16,17,18,19,20);
        list.set(2,76);//将第2+1个元素改变为76
        //list.add(99); 不能调整尺寸 list元素
        System.out.println(collection);
        System.out.println(list);
    }
}
