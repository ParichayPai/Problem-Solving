package com.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReduceArray {
//    public static String reduceArray(String str){
//        int oneCount = 0, zeroCount = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if(str.charAt(i)=='1')
//                oneCount++;
//            else
//                zeroCount++;
//        }
//        if(zeroCount==0||oneCount==0)
//            return "-1";
//        if(zeroCount>oneCount)
//            return "0";
//        else
//            return "1";
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        String str = br.readLine();
//        str = str.replaceAll(" ","");
//
//        for (int i = 0; i < str.length()-3; i++) {
//            if(str.charAt(i)=='0' && str.charAt(i+1)=='0' && str.charAt(i+2)=='0'){
//                System.out.println("0");
//                return;
//            }
//            if(str.charAt(i)=='1' && str.charAt(i+1)=='1' && str.charAt(i+2)=='1'){
//                System.out.println("0");
//                return;
//            }
//        }
//
//        String s1 = str;
//        boolean flag = false;
//        while (s1.length()>3){
//            String s = reduceArray(s1.substring(0,3));
////            System.out.println(s);
//            if(s.equals("-1")){
//                flag = true;
//                break;
//            }
//            String s2 = s1.substring(3,s1.length());
////            System.out.println(s2);
//            s1 = s+s2;
//        }
//        if(flag){
//            System.out.println("0");
//            return;
//        }
//        s1 = reduceArray(s1);
//        if(s1.length()==1)
//            System.out.println("1");
//        else
//            System.out.println("0");
//    }
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int size = Integer.parseInt(br.readLine());
         String line2[] = br.readLine().split(" ");
         int a[] = new int[size + 1];

         int countone = 0, countzero = 0 ;
         for (int i = 1; i <= size; i++) {
             a[i] = Integer.parseInt(line2[i - 1]);
             if(a[i] == 1)
                 countone++;
             else
                 countzero++;
         }
         if(Math.abs(countone - countzero) == 1)
             System.out.print("1");
         else
             System.out.print("0");

     }
}
