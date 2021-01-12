package com.ContestInterviewPrep10Jan;

/*
Given a binary array A[] of size N. The task is to arrange an array in increasing order.
(O(N) time complexity solution)
Input
Every test case contains two lines, first line contains an integer N (size of array) and second line contains space separated elements of array.

1 <= N <= 20
0 <= A[i] <= 1
Output
Print a single line containing space separated elements of sorted arrays.
Input:
5
1 0 1 1 0

Output:
0 0 1 1 1
 */

import java.util.Scanner;

public class sortBinaryArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int zeroCount = 0, oneCount = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] == 0)
                zeroCount++;
            else
                oneCount++;
        }
        while(zeroCount-- > 0){
            System.out.print(0+" ");
        }
        while(oneCount-- > 0){
            System.out.print(1+" ");
        }
    }
}
