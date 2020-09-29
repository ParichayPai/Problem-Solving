package com.regexUtil;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexUtil {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("ab");
        Matcher m = p.matcher("abaacaba");
        while(m.find()){
            System.out.print(m.start()+" ");
        }
    }
}
