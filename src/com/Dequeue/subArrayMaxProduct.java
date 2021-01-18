package com.Dequeue;

/*
Given an array, A of N integers. Find the product of maximum values for every subarray of size K. Print the answer modulo 1000000007.

A subarray is any contiguous sequence of elements in an array.
Input
First line contains two integers N and K, denoting the size of array and the size of subarray respectively.
Next line contains N integers denoting the elements of the array.

1 <= K <= N <= 1000000
1 <= A[i] <= 1000000
Output
Print a single integer denoting the product of maximums for every subarray of size K modulo 1000000007
Sample Input 1:
6 4
1 5 2 3 6 4

Sample Output 1:
180

Explanation:
For subarray [1, 5, 2, 3], maximum = 5
For subarray [5, 2, 3, 6], maximum = 6
For subarray [2, 3, 6, 4], maximum = 6
Therefore, ans = 5*6*6 = 180
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class subArrayMaxProduct {
    static void printMax(int[] arr, int n, int k) {
        long ans = 1;
        Deque<Integer> Qi = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
            Qi.addLast(i);
        }

        for (int i = k; i < n; ++i) {
            ans = (ans * arr[Qi.peek()])%1000000007;
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
                Qi.removeFirst();
            while ((!Qi.isEmpty()) && arr[i] >=
                    arr[Qi.peekLast()])
                Qi.removeLast();
            Qi.addLast(i);
        }

        ans = (ans * arr[Qi.peek()])%1000000007;;
        System.out.println(ans);
    }
//    static void findKMaxElement(int[] arr, int k, int n) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
//        long ans = 1;
//
//        for (int i = 0; i < k; i++)
//            queue.add(arr[i]);
//
//        ans = (ans*queue.peek())%1000000007;
//        queue.remove(arr[0]);
//
//        for (int i = k; i < n; i++) {
//            queue.add(arr[i]);
//            ans = (ans*queue.peek())%1000000007;
//            queue.remove(arr[i - k + 1]);
//        }
//        System.out.println(ans);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);
        String[] line2 = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line2[i]);
        }

        printMax(arr, n, k);
    }
//    static long checkMax(int[] arr, Deque<Integer> q, int i, int k){
//        if(q.size() < k){
//            if(q.isEmpty())
//                q.add(i);
//            else{
//                if(arr[i] > arr[q.peekLast()])
//                    q.addLast(i);
//                else
//                    q.addFirst(i);
//            }
//            System.out.println(q);
//        }else {
//            while(q.size() > k && Math.abs(i - q.peekLast()) >  k)
//                q.removeLast();
//            if(arr[i] > arr[q.peekLast()])
//                q.addLast(i);
//            else
//                q.addFirst(i);
//            System.out.println(q);
//        }
//        return arr[q.peekLast()];
//    }
//
//    static void getSubArrayMaxProduct(int[] arr, int k){
//        Deque<Integer> q = new LinkedList<>();
//        long product = 1;
//        for (int i = 0; i < k; i++) {
//            checkMax(arr, q, i, k);
//            System.out.println(product);
//        }
//        product *= arr[q.peekLast()];
//        System.out.println("---");
//        for (int i = k; i < arr.length; i++) {
//            product *= checkMax(arr, q, i, k);
//            System.out.println(product);
//        }
//        System.out.println(product);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] line1 = br.readLine().split(" ");
//        int n = Integer.parseInt(line1[0]);
//        int k = Integer.parseInt(line1[1]);
//        String[] line2 = br.readLine().split(" ");
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(line2[i]);
//        }
//        getSubArrayMaxProduct(arr, k);
//    }
}
