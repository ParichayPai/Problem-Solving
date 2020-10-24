package com.arrays;

import java.util.Scanner;

public class findSingleElement {
    public static int findSingle(int[] arr, int arr_size) {
        int res = arr[0];
        for (int i = 1; i < arr_size; i++)
            res = res ^ arr[i];

        return res;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Non repeating element is " + findSingle(arr, n));
    }
}
