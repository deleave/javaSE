package com.容器;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//List方法
class MyList {
    String c="Hello";
    private  int num = 0;
    MyList(){
        num++;
        System.out.println(c);

    }
    public String toString(){
        return "MyList "+num++;
    }
}
class MyList1 extends MyList{
    String m="Cool dog";
    private int mn=0;
    MyList1()
    {
        ++mn;
        System.out.println(" "+m);
    }
    public String toString(){
        return "MyList1 "+mn;
    }
}
public class SubList {
    public static void main(String[] args) {
        MyList n=new MyList();
        //存在改变List的操作，在另一个容器中创建一个副本
        List<MyList> myLists=new ArrayList<MyList>(Arrays.<MyList>asList(new MyList(),new MyList1(),new MyList1(),new MyList1()));
        myLists.add(new MyList()); //不能调整List的尺寸
        System.out.println("myLists"+myLists);
        List<MyList> sub=myLists.subList(1,myLists.size());
        System.out.println("sub"+sub);
//        myLists.removeAll(sub);  不能调整List的尺寸
        System.out.println("removeAll"+myLists);
    }
}
