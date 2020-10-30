package com.stringProblems;

import java.util.Scanner;

public class smallestString {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < n){
            if(i%2==0){
                sb.append("a");
            }else{
                sb.append("b");
            }
            i++;
        }
        System.out.println(sb);
    }
}

