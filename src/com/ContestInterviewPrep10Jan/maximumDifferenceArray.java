package com.ContestInterviewPrep10Jan;

/*
Given an array of integers of size N, your task is to find the maximum j - i such that Arr[j] > Arr[i] where 0 < = i < j < = N-1.
Input
First line of contains a single integer N, next line contains N space separated integers depicting the values of array.

Constraints:-
1 < = N < = 100000
1 < = Arr[i] < = 100000
Output
Print the maximum value of j- i under the given condition, if no pair satisfies the condition print -1.
Sample Input:-
5
1 2 3 4 5

Sample Output:-
4

Sample Input:-
5
5 4 3 2 1

Sample Output:-
-1
 */

import java.util.Scanner;

public class maximumDifferenceArray {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int maxLength = -1;
//        for (int i = 0; i < n; i++) {
//            int index = arr.length-1;
//            while(index > i && arr[index] <= arr[i])
//                index--;
//            maxLength = Math.max(maxLength, index - i);
//        }
//        System.out.println(maxLength == 0 ? -1 : maxLength);
//    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int max = -1;
        int[] rightArr = new int[n];
        int[] leftArr = new int[n];
        leftArr[0] = arr[0];
        for(int i = 1; i < n; i++)
            leftArr[i] = Math.min(arr[i], leftArr[i - 1]);
        rightArr[n-1] = arr[n-1];
        for(int j = n-2; j >= 0; j--)
            rightArr[j] = Math.max(arr[j], rightArr[j + 1]);
        int i = 0, j = 0;
        while(i < n && j < n) {
            if(leftArr[i] < rightArr[j]) {
                max = Math.max(max, j - i);
                j++;
            } else {
                i++;
            }
        }
        System.out.println(max);
    }
}
