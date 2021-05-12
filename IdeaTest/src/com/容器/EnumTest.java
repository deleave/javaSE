package com.容器;


import java.util.EnumMap;
import java.util.EnumSet;

enum Weekday{
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
}
public class EnumTest {
    public static void main(String[] args) {
        //创建一个包含指定所有元素的枚举集元素类型
        EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
        System.out.println("返回全集："+always);
        //创建具有指定元素类型的空枚举集
        EnumSet<Weekday> never = EnumSet.noneOf(Weekday.class);
        System.out.println("返回空集："+never);
        //创建一个最初包含所有元素的枚举集由两个指定端点定义的范围。 返回的集合将包含端点本身
        EnumSet<Weekday> range = EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);
        System.out.println("返回范围里的枚举类型"+range);
        //创建最初包含指定元素的枚举集。
        EnumSet<Weekday> mwf = EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        System.out.println(mwf);
        //利用键为枚举类型的映射
        EnumMap<Weekday,String> em=new EnumMap<Weekday, String>(Weekday.class);
        em.put(Weekday.SUNDAY,"Amy");
        em.put(Weekday.FRIDAY,"Rachel");
        System.out.println("EnumMap："+em);
    }


}
