package com.arrays;

/*
Given an array of N integers, your task is to find the longest subsequence such that the difference between adjacent numbers in the subsequence is equal to 1
Input
First line of input contains a single integer N. Next line of input contains N space- separated integers depicting the elements of the array.

Constraints:-
1 <= N <= 1000
1 <= Arr[i] <= 10000
Output
Print the length of the longest subsequence.

Sample Input:-
5
4 6 1 5 4

Sample Output:-
3

Explanation:-
there are two subsequences of size 3 that fit this criterion:- 4 5 4 and 6 5 4

Sample input:-
8
1 2 3 2 3 7 2 1

Sample Output:-
7
*/

import java.util.Arrays;
import java.util.Scanner;

public class subsequenceDiff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] countArr = new int[n];
        Arrays.fill(countArr, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] == arr[j]+1 || arr[i] == arr[j]-1){
                    countArr[i] = Math.max(countArr[i], countArr[j] + 1);
                }
            }
        }
        int count = 0;
        for (int i = 0 ; i < n ; i++){
            if (count < countArr[i]){
                count = countArr[i];
            }
        }
        System.out.println(count);
    }
}
