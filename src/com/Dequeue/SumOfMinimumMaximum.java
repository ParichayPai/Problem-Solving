package com.Dequeue;

/*
Given an array of size N, your task is to calculate the total sum of maximum and minimum elements in each subarray of size K.
See example for better understanding.
Input
First line of input contains an two space separated integers depicting values of N and K, next line contains N space separated integers depicting values of Arr[i].

Constraints:-
1 < = k < = N < = 100000
-100000 < = Arr[i] < = 100000
Output
Print the required sum
Sample Input:-
5 3
1 2 3 4 5

Sample Output:-
18

Explanation:-
For subarray 1 2 3 :- 1 + 3 = 4
For subarray 2 3 4 :- 2 + 4 = 6
For subarray 3 4 5 :- 3 + 5 = 8
total sum = 4+6+8 = 18

Sample Input:-
7 4
2 5 -1 7 -3 -1 -2

Sample Output:-
18
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class SumOfMinimumMaximum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] arr = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        long sum = getSumOfMinimumMaximum(arr, n, k);
        System.out.println(sum);
    }

    public static long getSumOfMinimumMaximum(int[] arr, int n, int k) {
        long sum = 0;
        Deque<Integer> smaller = new LinkedList<>();
        Deque<Integer> greater = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!smaller.isEmpty() && arr[smaller.peekLast()] >= arr[i])
                smaller.removeLast();

            while (!greater.isEmpty() && arr[greater.peekLast()] <= arr[i])
                greater.removeLast();
            greater.addLast(i);
            smaller.addLast(i);
        }

        for (int i = k; i < arr.length; i++) {
            sum += arr[smaller.peekFirst()] + arr[greater.peekFirst()];

            while (!smaller.isEmpty() && smaller.peekFirst() <= i - k)
                smaller.removeFirst();
            while (!greater.isEmpty() && greater.peekFirst() <= i - k)
                greater.removeFirst();

            while (!smaller.isEmpty() && arr[smaller.peekLast()] >= arr[i])
                smaller.removeLast();

            while (!greater.isEmpty() && arr[greater.peekLast()] <= arr[i])
                greater.removeLast();

            greater.addLast(i);
            smaller.addLast(i);
        }
        sum += arr[smaller.peekFirst()] + arr[greater.peekFirst()];

        return sum;
    }
}
