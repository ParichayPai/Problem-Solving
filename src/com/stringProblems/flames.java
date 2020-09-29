package com.stringProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class flames {
    // public static int printFlames(String str1, String str2){
    //     Set<Character> set = new HashSet<>();
    //     for(int i=0;i<str1.length();i++){
    //         if(str2.contains(Character.toString(str1.charAt(i))))
    //             set.add(str1.charAt(i));
    //     }
    //     for(Character c : set){
    //         str1 = str1.replaceFirst(c+"","");
    //         str2 = str2.replaceFirst(c+"","");
    //     }
    //     // System.out.println(str1+" "+str2);
    //     return (str1.length() + str2.length())%6;
    // }
//    public static int printFlames(String str1, String str2){
//        Set<Character> set = new HashSet<>();
//        char[] arr = new char[str1.length()];
//        for(int i=0;i<str1.length();i++){
//            if(str2.contains(Character.toString(str1.charAt(i))))
//                arr[i] = str1.charAt(i);
//            else
//                arr[i] = 'A';
//        }
//        for (char c : arr) {
//            if (str1.contains(Character.toString(c)) && str2.contains(Character.toString(c))) {
//                str1 = str1.replaceFirst(c + "", "");
//                str2 = str2.replaceFirst(c + "", "");
//            }
//        }
        // System.out.println(str1+" "+str2);
//        return (str1.length() + str2.length())%6;
//        int[] freq1 = new int[256];
//        int[] freq2 = new int[256];
//
//        int l = 0;
//        l = Math.min(str1.length(), str2.length());
//
//        for (int i = 0; i < str1.length(); i++) {
//            freq1[str1.charAt(i)]++;
//        }
//        for (int i = 0; i < str2.length(); i++) {
//            freq2[str2.charAt(i)]++;
//        }
//        int length = 0;
//        for (int i = 0; i < l; i++) {
//            if (freq1[i]==freq2[i]){
//                freq1[i] = freq2[i] = 0;
//            }
//            else{
//                int m = Math.min(freq1[i], freq2[i]);
//                freq1[i] -= m;
//                freq2[i] -= m;
//            }
//        }
//        for (int i = 0; i < l; i++) {
//            length += freq1[i] + freq2[i];
//        }
////        System.out.println(length);
//        return length%6;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str1 = sc.next();
//        String str2 = sc.next();
//        int length = printFlames(str1,str2);
//        switch (length){
//            case 0:
//                System.out.println("Siblings");
//                break;
//            case 1:
//                System.out.println("Friends");
//                break;
//            case 2:
//                System.out.println("Love");
//                break;
//            case 3:
//                System.out.println("Affection");
//                break;
//            case 4:
//                System.out.println("Marriage");
//                break;
//            case 5:
//                System.out.println("Enemy");
//                break;
//        }
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for(int i  = 0 ; i < s1.length() ; i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i),0) + 1);
        }
        long count = 0;
        for(int i  = 0 ; i < s2.length() ; i++){
            if(map.containsKey(s2.charAt(i))){
                Integer c = map.get(s2.charAt(i));
                if(c == 1){
                    map.remove(s2.charAt(i));
                }
                else
                    map.put(s2.charAt(i), c - 1);
            }
            else
                count++;
        }
        long sum = 0;
        for(Map.Entry<Character , Integer> entry : map.entrySet())
            sum += entry.getValue();
        checkFlames((sum + count) % 6);
    }
    public static void checkFlames(long i){
        StringBuffer sb = new StringBuffer();
        if(i == 0)
            sb.append("Siblings");
        else if(i == 1)
            sb.append("Friends");
        else if(i == 2)
            sb.append("Love");
        else if(i == 3)
            sb.append("Affection");
        else if(i == 4)
            sb.append("Marriage");
        else if(i == 5)
            sb.append("Enemy");

        System.out.print(sb);
    }
}
