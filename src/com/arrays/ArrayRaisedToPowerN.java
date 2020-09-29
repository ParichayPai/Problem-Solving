package com.arrays;

import java.util.Scanner;

public class ArrayRaisedToPowerN {
    public static int[][] multiplyArray(int[][] arr1, int[][] arr2, int n){
        int[][] output = new int[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    output[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return output;
    }
    public static void arrayRaisedToPowerN(int[][] arr, int[][] arrCopy, int n, int p){
        int[][] op = arr;
        while(p-- > 1){
            op = multiplyArray(op,arrCopy,n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(op[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] arrCopy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                arrCopy[i][j] = arr[i][j];
            }
        }
        arrayRaisedToPowerN(arr,arrCopy, n, p);
    }
}
/*
3 4
1 0 0   1 0 0
1 1 1   7 5 3
0 1 0   4 3 2
 */
