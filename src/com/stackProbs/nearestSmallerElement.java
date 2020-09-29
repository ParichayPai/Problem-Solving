package com.stackProbs;

/*
Given an array A, find the nearest smaller element S[i] for every
element A[i] in the array such that the element has an index smaller than i.

More formally,
S[i] for an element A[i] = an element A[j] such that
j is maximum possible AND
j < i AND
A[j] <= A[i]
Elements for which no smaller element exist, consider next smaller element as -1.
Input
The first line contains the size of array, n
The next line n elements of the integer array, A[i]

Constraints:
1 <= n <= 10^5
1 <= A[i] <= 10^6
Output
Print the integer array S such that S[i] contains nearest smaller number
than A[i] such than index of S[i] is less than 'i'. If no such element
occurs S[i] should be -1.

Input:
5
4 5 2 10 8

Output:
-1 4 -1 2 2

Explanation 1:
    index 1: No element less than 4 in left of 4, G[1] = -1
    index 2: A[1] is only element less than A[2], G[2] = A[1]
    index 3: No element less than 2 in left of 2, G[3] = -1
    index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
    index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]

Input:
5
1 2 3 4 5

Output:
-1 1 2 3 4
 */

import java.util.Scanner;
import java.util.Stack;

public class nearestSmallerElement {
    public static void printNearestSmallerElement(long[] arr, int n) {
        long[] answerArray = new long[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n; i++ ) {
            long ele = arr[i];
            if(!st.isEmpty() || ele >= arr[st.peek()]){
                answerArray[i] = arr[st.peek()];
            }else{
                while(!st.isEmpty() && ele < arr[st.peek()]){
                    st.pop();
                }
                if(!st.isEmpty())
                    answerArray[i] = arr[st.peek()];
            }
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            if(answerArray[i]==0)
                System.out.print("-1 ");
            else
                System.out.print(answerArray[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextLong();
        printNearestSmallerElement(arr,n);
    }
}
