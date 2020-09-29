package com.arrays;

/*
Given an integer array arr and a target value K, return the integer
value V such that when we change all the integers larger than V in
the given array to be equal to V, the sum of the array gets as close
as possible (in absolute difference) to K.

In case of a tie, return the minimum such integer.

Note: the answer is not necessarily a number from arr.
Input
The input line containing T, denoting the number of testcases.
Each testcase contains 2 lines. First line contains N, size of array
and target K separated by space. Second line contains elements of array.

Constraints:
1 <= T <= 50
1 <= N <= 10^4
1 <= arr[i], K <= 10^5
Output
For each testcase you need to print the minimum such integer possible
in a new line.
Example

Input:
2
3 10
4 9 3
3 10
2 3 5

Output:
3
5

Explanation:
Testcase 1: When using 3 arr converts to [3, 3, 3] which sums 9 and
that's the optimal answer.
 */

import java.util.Arrays;
import java.util.Scanner;

public class MutatingArray {
    static int Sum(int[] arr, int mid){
        int sum = 0;
        for (int j : arr) {
            sum += Math.min(j, mid);
        }
        return sum;
    }
    static int closestValue(int[] arr, int k) {
        int end = 0,sum=0;
        for (int j : arr) {
            sum += j;
            end = Math.max(end, j);
        }
        int start = 0;
        while (start+1 < end) {
            int mid = start + (end - start) / 2;
            if (Sum(arr, mid) > k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        System.out.println("Start "+Sum(arr,start));
        if (Math.abs(Sum(arr, end) - k) < Math.abs(Sum(arr, start) - k)) {
            return end;
        }
        return start;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(closestValue(arr, k));
        }
    }
}
