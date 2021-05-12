package com.容器;
import java.util.*;
//comparable ：是在你要排序的类中去实现comparable接口，
// 也就是说你得在你要排序的类中先写一个方法用来声明你想让你类中的属性根据什么规则来排序
class Item implements Comparable<Item>{
    private String description;
    private int partNumber;
    public Item(String adescription,int apartNumber){
        this.description=adescription;
        this.partNumber=apartNumber;
    }
    public String getDescription(){
        return description;
    }
    public String toString(){
        return "[description="+description+",partNumber="+partNumber+"]";
    }
    public boolean equals(Object otherObject){
        if (this==otherObject) return true;
        if (otherObject==null) return false;
        if (getClass()!=otherObject.getClass()) return false;
        Item other=(Item) otherObject;
        return Objects.equals(description,other.description)&&partNumber==other.partNumber;
    }
    public int hashCode(){
        return Objects.hash(description,partNumber);
    }

    @Override
    //输出是按照compareTo顺序来输出 首先比较partNumber 其次比较description 都相同则不存
    public int compareTo(Item other) {
        int diff=Integer.compare(partNumber,other.partNumber);
        return diff!=0?diff:description.compareTo(other.description);

    }
}
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts=new TreeSet<>();
        parts.add(new Item("Toaster",12));
        parts.add(new Item("Widget",34));
        parts.add(new Item("Modem",78));
        parts.add(new Item("Amy",56));
        TreeSet p=new TreeSet<>();
        p.add(new Item("Toaster",12));
        p.add(new Item("Widget",34));
        p.add(new Item("Modem",78));
        p.add(new Item("Amy",1));
        //相同实例存不进去
        p.add(new Item("Amy",1));
        Item item=new Item("ReCheol",8);
        System.out.println(item.compareTo(item));//相同返回0 大于取正 小于取负
        System.out.println(item.hashCode());
        System.out.println(item.getDescription());
        System.out.println(item.equals(12));
        //按照部件编号排序
        System.out.println(p);
        System.out.println(parts);
        //通过使用一个定制的比较器来按照描述信息排序
        NavigableSet<Item> sortByDescription=new TreeSet<>();
        Comparator.comparing(Item::getDescription);
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
        sortByDescription.addAll(p);
        System.out.println(p);
    }
}
