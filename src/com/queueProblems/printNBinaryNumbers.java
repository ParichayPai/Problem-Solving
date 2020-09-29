package com.queueProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class printNBinaryNumbers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n-- > 0){
            String s = q.remove();
            System.out.print(s+" ");
            q.add(s+"0");
            q.add(s+"1");
        }
    }
}
