package com.ContestInterviewPrep_9Jan;

/*
Given an array arr[] of N positive integers and a number K. The task is to find the kth largest element in the array.

Note: DO NOT USE sort() stl.
Input
First line of input contains number of testcases. For each testcase, there will be a single line of input containing number of elements in the array and K. Next line contains N elements.

Constraints:
1 <= T <= 100
1 <= N <= 10^4
1 <= arr[i] <= 10^5
1 <= K <= N
Output
For each testcase, print a single line of output containing the kth largest element in the array.
Sample Input:
2
5 3
3 5 4 2 9
5 5
4 3 7 6 5

Sample Output:
4
3

Explanation:
Testcase 1: Third largest element in the array is 4.
Testcase 2: Fifth largest element in the array is 3.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kthLargestEle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            String[] line1 = br.readLine().split(" ");
            int n = Integer.parseInt(line1[0]);
            int k = Integer.parseInt(line1[1]);
            String[] line2 = br.readLine().split(" ");
            int[] arr = new int[100001];
            for(int i = 0; i < n; i++){
                arr[Integer.parseInt(line2[i])]++;
            }
            int ans = 0;
            for(int i = arr.length-1; i >= 0; i--){
                if(arr[i]>0){
                    k -= arr[i];
                    ans = i;
                    if(k<=0){
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
