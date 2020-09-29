package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*
Given an array Arr, of N integers find the sum of max(A[i], A[j]) for all i, j such that i < j.
Input
The first line of the input contains an integer N, the size of the array.
The second line of the input contains N integers, the elements of the array Arr.

Constraints
1 <= N <= 100000
1 <= Arr[i] <= 100000000
Output
Print a single integer which is the sum of min(A[i], A[j]) for all i, j such that i < j.
Sample Input
4
5 3 3 1

Sample Output
24

Explanation: max(5,3) + max(5,3) + max(5,1) + max(3,3) + max(3,1) + max(3,1) = 24

Sample Input
2
1 10

Sample Output
10
 */
public class PairSum2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 =br.readLine().split(" ");
        String[] line2 =br.readLine().split(" ");
        int size = Integer.parseInt(line1[0]);
        Integer [] arr = new Integer[size];
        for(int i = 0 ; i < size ; i++){
            arr[i] = Integer.parseInt(line2[i]);
        }
        long sum = 0;
        Arrays.sort(arr , Collections.reverseOrder());
        for(int i = 0 ; i < size ;i++){
            sum += ((long)(arr[i])*(size-1 - i));
        }
        System.out.println(sum);
    }
}
