package com.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class minimumSum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        StringBuilder st = new StringBuilder();
        StringBuilder st2 = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i = 0 ; i < n ; i = i+2){
            st.append(arr[i]);
        }
        for(int i = 1 ; i < n ; i = i+2){
            st2.append(arr[i]);
        }
        sum = Long.parseLong(st.toString());
        sum += Long.parseLong(st2.toString());
        System.out.print(sum);
    }
}
