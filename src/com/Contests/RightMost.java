package com.Contests;

/*
Given an Array Arr of N integers. For each i from 1 to N find the index j
such that Arr[j] >= Arr[i] for multiple possible j find the rightmost j.
Input
First line of input contains a single integer N.
Second line of input contains N integers, denoting the elements of the array.

Constraints:
1 <= N <= 100000
1 <= Arr[i] <= 1000000000
Output
Print N space separated integers the values of j for each i from 1 to N.

Example
Sample Input:
5
5 2 4 3 1

Sample Output:
1 4 3 4 5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RightMost {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        long[] ans = new long[n];

        String[] line = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            arr[i] = Long.parseLong(line[i]);

        long[] maxArray = new long[n];
        maxArray[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--)
            maxArray[i] = Math.max(maxArray[i+1],arr[i]);

        for(int i = 0; i < n; i++){
            int start = i;
            int end = n-1;

            while(start <= end){
                int mid = start + (end-start) / 2;
                if(maxArray[mid] >= arr[i]){
                    ans[i] = mid+1;
                    start = mid+1;
                }
                else{
                    end = mid - 1;
                }
            }

        }
        for(int i = 0; i < n; i++)
            System.out.print(ans[i]+" ");
    }
}
