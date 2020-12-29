package com.InterviewPrep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given an array A containing a permutation of N numbers. Find the number of indices i such that A[i] <= A[j] for all the values of j satisfying 1 <= j <= i.
Input
The first line of the input contains an input N, the size of the permutation.
The second line of the input contains N singly spaced integers, the elements of the permutation P.

1 <= N <= 200000
1 <= P[i] <= N
P is a permutation of first N natural numbers.
Output
Output a single integer, the answer to the problem.
Sample Input
6
3 2 5 6 1 4

Sample Output
3

Explanation: The indices i=1, i=2, i=5 satisfy the condition.

Sample Input
3
1 2 3

Sample Output
1
 */

public class smallIsBest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        int currentMin = n, count = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] <= currentMin){
                count++;
                currentMin = arr[i];
            }
        }
        System.out.println(count);
    }
}
