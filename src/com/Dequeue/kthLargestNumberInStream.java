package com.Dequeue;

/*
Given an input stream of n integers, find the kth largest element for each element in the stream.
Input
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
Each test case contains two lines. The first line of each test case contains two space-separated integers n and k. Then in the next line are n space-separated values of the array.

Constraints:
1 <= T <= 100
1 <= n <= 10^3
1 <= K <= n
1 <= stream[i] <= 10^5
Output
For each test case, in a new line, print the space separated values denoting the kth largest element at each insertion, if the kth largest element at a particular insertion in the stream doesn't exist print -1.
Sample Input:
2
6 4
1 2 3 4 5 6
2 1
3 4

Sample Output:
-1 -1 -1 1 2 3
3 4

Explanation:
Testcase1:
k = 4
For 1, the 4th largest element doesn't exist so we print -1.
For 2, the 4th largest element doesn't exist so we print -1.
For 3, the 4th largest element doesn't exist so we print -1.
For 4, the 4th largest element is 1 {1, 2, 3, 4}
For 5, the 4th largest element is 2 {2, 3, 4 ,5}
for 6, the 4th largest element is 3 {3, 4, 5}
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class kthLargestNumberInStream {
    static void getKthLargestNumber(int[] arr, int n, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //Collections.reverseOrder()
        for (int i = 0; i < k-1; i++) {
            pq.add(arr[i]);
            System.out.print("-1 ");
        }
        pq.add(arr[k-1]);

        for (int i = k; i < n; i++) {
            System.out.print(pq.peek()+" ");

            if (arr[i] > pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        System.out.print(pq.peek());
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
            getKthLargestNumber(arr, n, k);
        }
    }
}
