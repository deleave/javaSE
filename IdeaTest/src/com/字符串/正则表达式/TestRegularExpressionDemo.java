package com.字符串.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpressionDemo {
    public static void main(String[] args) {
        String sen="Java now has regular expression";
        String[] res={"^Java","\\Breg.*","n.w\\s+h(a|i)s","s?","s*","s+","s{4}","s{1}","s{0,3}"};
        String sen1="Arline ate eight apples and one orange while Anita hadn't any";
        Matcher m1=Pattern.compile("(?i)((^[aeiou]|(\\s+[aeiou]))\\w+?[aeiou]\\b)").matcher(sen1);
        if(m1.find())
        System.out.println("MatchFirst \""+m1.group()+"\"at positions "+m1.start()+"-"+(m1.end()-1));
        for (String r:res
             ) {
            System.out.println("Regular Expression "+r);
            Pattern p=Pattern.compile(r);
            Matcher m=p.matcher(sen);
            if(!m.find()){
                System.out.println("Not Find!");
            }
            while (m.find()){
                System.out.println("Match \""+m.group()+"\"at positions "+m.start()+"-"+(m.end()-1));
            }

        }

    }
}
