package com.stringProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class isoString {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char ch = 'a';
        StringBuilder sb = new StringBuilder("");

        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                sb.append(sb.charAt(map.get(s.charAt(i))));
            }
            else{
                sb.append(ch);
                map.put(s.charAt(i),i);
                ch++;
            }
        }
        System.out.println(sb.toString());
    }
}
