package com.Contests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABCProblem {
//    public static void main (String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int inp = sc.nextInt();
//        int z = 1;
//        StringBuilder s = new StringBuilder();
//        while(z <= inp){
//            int count = 0;
//            List<Integer> arrl = new ArrayList<>();
//            for(int k=0;k<=z;k++){
//                if(z-k*k >= 0)
//                    arrl.add(z-k*k);
//            }
//            List<Integer> arrl1 = new ArrayList<>();
//            for(int i=0;i<=z;i++){
//                for(int j=0;j<=z;j++){
//                    arrl1.add(i*i+j*j);
//                }
//            }
//
//            for (Integer value : arrl) {
//                for (Integer integer : arrl1) {
//                    if (value.equals(integer))
//                        count++;
//                }
//            }
//
//            s.append(count).append("\n");
//            z++;
//        }
//        System.out.println(s);
//    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n;i++){
            int root = (int)Math.sqrt(i);
            int count = 0;
            for(int a = 0; a <= root; a++){
                for(int b = 0; b <= root; b++){
                    if(a*a + b*b > i)
                        break;
                    int c2 = i - (a*a+b*b);
                    int c = (int)Math.sqrt(c2);
                    if(c2 == (c*c)){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
