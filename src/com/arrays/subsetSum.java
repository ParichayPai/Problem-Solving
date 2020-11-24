package com.arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
Given an array of N integers and a target sum S, your task is to check if there is any subset present whose sum is equal to the target sum.
Input
The first line of input contains two integers N and S. Next line contains N space- separated integers depicting the values of the array.

Constraints:-
1 <= N <= 1000
1 <= S <= 1000
1 <= Arr[i] <= 1000
Output
Print "YES" if there exists a subset else print "NO".

Sample Input:-
6 9
3 34 4 12 5 2

Sample Output:-
YES

Sample Input:-
4 16
1 2 4 8

Sample Output:-
NO
 */

public class subsetSum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int sum = 0;
        int[] arr = new int[n];
        for(int i = 0 ;i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int start = 0;
        boolean flag = false;
        for(int i = 0 ; i < n ; i++){
            sum += arr[i];
            if(sum==target){
                System.out.print("YES");
                flag = true;
                break;
            }
            else if(sum > target){
                while(sum > target){
                    sum -= arr[start];
                    start++;
                }
            }
            if(sum==target){
                System.out.print("YES");
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.print("NO");
        }
    }
}
