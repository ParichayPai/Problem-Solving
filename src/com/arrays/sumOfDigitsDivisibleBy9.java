package com.arrays;

import java.util.Scanner;

public class sumOfDigitsDivisibleBy9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = 9*i;
        }
        System.out.println(arr[n-1]);
    }
}
