package com.字符串.正则表达式;

import com.IO流.BufferedInputFile;
import java.io.IOException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReplacements {
    public static void main(String[] args) throws IOException {
        String s= BufferedInputFile.read("ReplacementsFile");
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/",Pattern.DOTALL).matcher(s);
        //如果匹配，s就指向为分组一
        if(mInput.find())
            s=mInput.group(1);
        //替换两个或以上的空格为一个空格
        s=s.replaceAll(" {2,}"," ");
        //s=s.replaceAll("\\b \\W","");
        //(?m)表示采用多行匹配模式 替换掉每行开头的空格
        s=s.replaceAll("(?m)^ +","");
        System.out.println(s);
        s=s.replaceFirst("[aeiou]","[VOWEL]");
        StringBuffer sbd=new StringBuffer();
        Pattern p=Pattern.compile("[aeiou]");
        Matcher m=p.matcher(s);
        while (m.find()){
            m.appendReplacement(sbd,m.group().toUpperCase(Locale.ROOT));
        }
        m.appendTail(sbd);
        System.out.println(sbd);
    }
}
