package com.interviewPrep23Jan;

/*
Given an array arr[] of N integers arranged in a circular fashion. Your task is to find the maximum contiguous subarray sum containing at least 1 element.
Input
The first line of input contains a single integer T which denotes the number of test cases. The first line of each test case contains a single integer N which denotes the total number of elements. The second line of each test case contains N space-separated integers denoting the elements of the array.

Constraints:
1 <= T <= 100
1 <= N <= 10^5
-10^6 <= Arr[i] <= 10^6

The Sum of N over all test cases is less than equal to 10^6.
Output
For each test case print the maximum sum obtained by adding the consecutive elements.
<b>Input:</b>
4
7
8 -8 9 -9 10 -11 12
8
10 -3 -4 7 6 5 -4 -1
8
-1 40 -14 7 6 5 -4 -1
4
-1 -2 -3 -4

<b>Output:</b>
22
23
52
-1

Explanation:
Testcase 1: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives the maximum sum as 22.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class maxCircularArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            System.out.println(maxCircularSum(arr, n));
        }
    }
    public static int maxCircularSum(int[] a, int n) {
        if (n == 1)
            return a[0];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        int currMax = a[0], maxSoFar = a[0];
        int currMin = a[0], minSoFar = a[0];

        // Concept of Kadane's Algorithm
        for (int i = 1; i < n; i++) {

            // Kadane's Algorithm to find Maximum subarray
            // sum.
            currMax = Math.max(currMax + a[i], a[i]);
            maxSoFar = Math.max(maxSoFar, currMax);

            // Kadane's Algorithm to find Minimum subarray
            // sum.
            currMin = Math.min(currMin + a[i], a[i]);
            minSoFar = Math.min(minSoFar, currMin);
        }
        if (minSoFar == sum) {
            return maxSoFar;
        }

        // returning the maximum value
        return Math.max(maxSoFar, sum - minSoFar);
    }
}
