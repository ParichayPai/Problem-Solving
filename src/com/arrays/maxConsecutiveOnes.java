package com.arrays;

/*
Given an array of size N consisting of only 0's and 1's, your task is to find the maximum number of consecutive's 1's you can get by flipping at most M 0's
Input
First line of input contains two space separated integers denoting values of N and M, next line contains N space separated integer denoting the values of array.

Constraints:-
1 < = M < = N < = 100000
0 < = Arr[i] < = 1
Output
Print the maximum number of consecutive 1's.
 */

import java.util.Scanner;

public class maxConsecutiveOnes {
    public static void bruteForce(int[] arr, int n, int m){
        int l = 0, r = 0, count = 0, window = 0;
        while(r < n){
            if(count <= m){
                if(arr[r] == 0)
                    count++;
                r++;
            }
            if(count > m){
                if(arr[l] == 0)
                    count--;
                l++;
            }
            if(count <= m && window < (r - l))
                window = Math.abs(r - l);
        }
        System.out.println(window);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        bruteForce(arr,n,m);
        // 5 1
        // 1 0 1 0 0
    }
}