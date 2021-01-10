package com.Queues;

/*
Given an array A and an integer K. Find the maximum for each and every contiguous subarray of size K.


Problem asked in Amazon, Flipkart.
Input
The first line of each test case contains a single integer N denoting the size of array and the size of subarray K. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Constraints:
1 ≤ N ≤ 10^5
1 ≤ K ≤ N
0 ≤ A[i] <= 10^5
Output
Print the maximum for every subarray of size K.

Sample Input:
9 3
1 2 3 1 4 5 2 3 6

Sample Output:
3 3 4 5 5 5 6

Explanation:
Starting from the first subarray of size k = 3, we have 3 as maximum. Moving the window forward, maximum element are as 3, 4, 5, 5, 5 and 6.
 */

import java.util.*;

public class maxInKSubArray {
    static void checkSubArray(Deque<Integer> deque, int[] arr, int i, int k){
        while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
            deque.removeLast();
        deque.addLast(i);
        while(!deque.isEmpty() && (i - deque.peekFirst()) >= k)
            deque.removeFirst();
    }

    static void findMaxInSubArray(int[] arr, int n, int k){
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k-1; i++) {
            checkSubArray(deque, arr, i, k);
        }
        for (int i = k-1; i < n; i++) {
            checkSubArray(deque, arr, i, k);
            System.out.println(arr[deque.peekFirst()]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findMaxInSubArray(arr, n, k);
    }
}
