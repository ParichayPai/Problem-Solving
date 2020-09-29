package com.arrays;

import java.util.Scanner;

public class ORgame {

    public static long nCr(long n, long r) {
        if(n<r)
            return 0;
        return nPr(n,r)/ factorial(r);
    }
    public static long factorial(long r) {
        if(r == 1)
            return 1;
        return r*factorial(r-1);
    }
    public static long nPr(long n, long r) {
        if(r==0){
            return 1;
        }
        if(r==1){
            return n;
        }
        return (n)*nPr(n-1, r-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String[] line = sc.nextLine().split(" ");
        int[] arr = new int[size];
        int even = 0;
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(line[i]);
            if(arr[i]%2==0)
                even++;
        }
        System.out.println(nCr(size,4) - nCr(even,4));
    }
}
/*
Given an array of N integers. Find the number of ways to choose (i, j, k, l) such that i < j < k < l and (A[i] v A[j] v A[k] v A[l]) is odd (where v is bitwise or operator).
Input
First line of input contains a single integer N. Second line contains N integers denoting array A.

Constraints:
1 <= N <= 50000
0 <= A[i] <= 100000
Output
Find the number of ways to choose (i, j, k, l) such that i < j < k < l and (A[i] v A[j] v A[k] v A[l]) is odd (where v is bitwise or operator).

Sample Input
5
1 2 3 4 5

Sample Output
5

Explanation: (2, 3, 4, 5) (1, 3, 4, 5) (1, 2, 4, 5) (1, 2, 3, 5) (1, 2, 3, 4) these follow all conditions.
 */
