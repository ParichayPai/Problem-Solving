package com.HeapPriorityQueues;

/*
Given an array of n positive integers. We are required to write a program to print the maximum product of k integers of the given array.
Input
The input line contains T, denoting the number of testcases. Each testcase contains 2 lines. First line contains size of array N and K. Second line contains elements of array

Constraints:
1 <= T <= 50
1 <= N <= 100
1 <= K <= min(N,10)
0 <= A[i] <= 100

It is guaranteed that answer will be less than 10^18.
Output
For each testcase you need to print the maximum product of K integers
Sample Input:
2
5 3
2 4 7 9 6
4 2
12 14 11 7

Sample Output:
378
168

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collections;
import java.util.PriorityQueue;

public class maxProductOfKnos {
    static String getMaxProduct(int[] arr, int n, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        BigInteger ans = new BigInteger(String.valueOf(1));
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            ans = ans.multiply(BigInteger.valueOf(pq.remove()));
        }
        return ans.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String[] line1 = br.readLine().split(" ");
            int n = Integer.parseInt(line1[0]);
            int k = Integer.parseInt(line1[1]);
            String[] line2 = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line2[i]);
            }
            System.out.println(getMaxProduct(arr, n, k));
        }
    }
}
