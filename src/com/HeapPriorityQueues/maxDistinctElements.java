package com.HeapPriorityQueues;

/*
Given an array of N Books B[], where B[i] denotes the number of pages P in i'th book. Now you need to find the maximum number of distinct books (having a different number of pages) after removing K books from the array.
Input
The input line contains T, denoting the number of testcases. Each testcase contains two lines. First line contains N, number of books and K, number of books you need to remove. Second line contains N positive integers denoting the number of pages in ith book.

Constraints:
1 <= T <= 100
1 <= N <= 10^4
1 <= K <= N
1 <= B[i] <= 10^4
Output
You need to print the maximum number of distinct books.
Sample Input:
2
7 3
5 7 5 5 1 2 2
6 4
1 2 3 4 5 6

Sample Output:
4
2

Explanation:
Testcase 1:
Remove 2 occurrences of books having 5 pages and 1 occurrence of book having 2 pages.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class maxDistinctElements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (t-- > 0){
            String[] line0 = br.readLine().split(" ");
            int n = Integer.parseInt(line0[0]);
            int k = Integer.parseInt(line0[1]);
            String[] arr = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                int no = Integer.parseInt(arr[i]);
                if(!pq.contains(no))
                    pq.add(no);
                else
                    k--;
            }
            int ans = pq.size();
            while(k-- > 0){
                ans--;
            }
            System.out.println(ans);
            pq.clear();
        }
    }
}
