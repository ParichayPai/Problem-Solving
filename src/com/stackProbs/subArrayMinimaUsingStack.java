package com.stackProbs;

/*
You are given an array(Arr) of N Distinct integers. You have to
find the sum of minimum element of all the subarrays (continous)
in that array. See Sample for better understanding.
Input
The first line of input contains N, the size of the array
The second line of input contains N space-separated integers
Constraints
2 ≤ N ≤ 100000
1 ≤ Arr[i] ≤ 1000000000
Output
The output should contain single integers, the sum of minimum
element of all the subarrays in that array.

Sample Input
3
1 2 3

Sample Output
10

Explaination
all subarrays [1] [1,2] [1,2,3] [2] [2,3] [3]
Sum of minimums : 1 + 1 + 1 + 2 + 2 + 3 = 10

 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class subArrayMinimaUsingStack {
    public static void printSubArrayMinima(long[] arr, int n) {
        long minimum = 0;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        long[] left = new long[n];
        long[] right = new long[n];
        for (int i = 0; i < n; i++) {
            left[i] = i;
            right[i] = n - i - 1;
        }
        for (int i = 0; i < n; i++) {
            while (!st1.isEmpty() && arr[st1.peek()] > arr[i]) {
                right[st1.peek()] = i - st1.peek() - 1;
                st1.pop();
            }
            st1.push(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!st2.isEmpty() && arr[st2.peek()] >= arr[i]) {
                left[st2.peek()] = st2.peek() - i - 1;
                st2.pop();
            }
            st2.push(i);
        }
        for (int i = 0; i < n; i++) {
            minimum += arr[i] * (left[i] + 1) * (right[i] + 1);
        }
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));
        System.out.println(minimum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * (n - i + 1);
        }
        printSubArrayMinima(arr, n);
    }
}
