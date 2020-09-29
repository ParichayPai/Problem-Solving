package com.Sorts;

/*
Given an array A[] with N elements, your task is to sort it using
counting sort algorithm.
Input
The first line of the input contains the number of test cases T.
For each test case, the first line contains the number of elements
N in the array A and the next line will contain the N elements
(space separated) of A[].


Constraints:
1 <= T <= 12
1 <= N <= 100
1 <= A[] <= 100000
Output
For each test case in a new line, you need to print the sorted array
using counting sort.

Sample Input:
3
4
8 1 3 7
3
1 3 7
6
6 1 3 7 4 9

Sample Output:
1 3 8 7
1 3 7
1 3 4 6 7 9
 */

import java.util.Scanner;

public class CountingSortUsingMap {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int[] freq = new int[100001];
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                freq[sc.nextInt()]++;
            for(int i=0;i<100001;i++){
                if(freq[i]!=0){
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }
    }
}
