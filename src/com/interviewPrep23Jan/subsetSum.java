package com.interviewPrep23Jan;

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class subsetSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int s = Integer.parseInt(line1[1]);
        String[] line2 = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line2[i]);
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = n-1; i >= 0; i--) {
            if(sum == s)
                break;
            if(arr[i] > s)
                continue;
            else if(arr[i] < s) {
                sum += arr[i];
                if(sum <= s)
                    continue;
                else{
                    sum -= arr[i];
                }
            }
            else if(arr[i] == s){
                sum = s;
                break;
            }
        }
        if(sum == s)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
