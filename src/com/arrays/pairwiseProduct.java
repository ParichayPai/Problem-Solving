package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class pairwiseProduct {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        long count = 0;
//        long[] preSum = new long[n];
//        for (int i = 1; i <= n; i++) {
//            preSum[i-1] = (i*(i+1)/2);
//        }
//        for (int i = 0; i < n; i++) {
//            count =(count + (i+1)*(preSum[n-1]-preSum[i]))%(long)(Math.pow(10,9)+7);
//        }
//        System.out.println(count);
//    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        long n = sc.nextLong();
        long add = (n*(n+1)/2);
        long result = 0;
        for(long i = 1; i < n; i++){
            long s = i*(add-(i*(i+1)/2));
            result = (result+s)%1000000007;
        }
        System.out.println(result);
    }
}
/*
1*(2+3+4) => (i+1)(preSum[n-1]-preSum[i]) 10 1
2(3+4) => (2)(preSum[]-preSum[])
 */