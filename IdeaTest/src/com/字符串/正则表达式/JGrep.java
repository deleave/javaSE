package com.字符串.正则表达式;

import com.IO流.BufferedInputFile;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {
    public static void main(String[] args) throws IOException {
        File file=new File("ReplacementsFile");
        File[] files=new File(".").listFiles();
//        if(args.length<2){
//            System.out.println("Usage: java JGrep file regex");
//            System.exit(0);
//        }
        Pattern p= Pattern.compile("\\b[Ssct]\\w+",Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);
        int index=0;
        Matcher m= p.matcher("");
        String s=BufferedInputFile.read("ReplacementsFile");
            m.reset(s);
            while (m.find()){
                System.out.println(index++ +": "+m.group()+": "+m.start());
            }

    }
}
