package com.容器;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//显式类型参数说明
//在Arrays.asList()中间插入一条“线索”以告诉编译器生成的list类型
class Snow{}
class powder extends Snow{}
class Light extends powder{}
class Heavy extends powder{}
class Crusty extends Snow{}
class Slush extends Snow{}
public class AsListInterface {
    public static void main(String[] args) {
        List<Snow> snows1= Arrays.asList(new Crusty(),new Slush());//snows1类型为Snow
        List<Snow> snows2=Arrays.asList(new Light(),new Heavy());
        List<Snow> snows3=new ArrayList<Snow>();
        //显示类型参数说明
        Collections.addAll(snows3,new Light(),new Heavy());
        List<Snow> snows4=Arrays.<Snow>asList(new Light(),new Heavy());
    }
}
