package com.stackProbs;

/*
Given an array A of size N, the task is to find the nearest
greater element G[i] for every element of A[i] such that the
element has index greater than i, If no such element exists, output -1.
More formally:
G[i] for an element A[i] = an element A[j] such that
j is minimum possible AND
j > i AND
A[j] > A[i]
Input
Each test case consists of two lines. The first line contains an
integer N denoting the size of the array. The Second line of each
test case contains N space separated positive integers denoting
the values/elements in the array A.

Constraints:
1 <= N <= 10^5
1 <= Ai <= 10^9
Output
For each test case, print the next greater element for each array
element separated by space in order.

Sample Input
4
1 3 2 4

Sample Output
3 4 4 -1

Sample Input
4
4 3 2 1

Sample Output
-1 -1 -1 -1
 */

import java.util.*;

public class nextGreaterElement {
    public static void printElement(int[] arr, int n) {
        int[] answerArray = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++){
            int ele = arr[i];
            if (!st.isEmpty() && ele > arr[st.peek()]){
                while (!st.isEmpty() && arr[st.peek()] < ele) {
                    answerArray[st.peek()] = ele;
                    st.pop();
                }
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            answerArray[st.pop()] = -1;
        }
        for(int i = 0 ; i < n ; i++)
            System.out.print(answerArray[i]+" ");
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        printElement(arr, n);
    }
    /*
    Approach 2
    public static void main(String[] args){
        int[] arr = {4,1,3,8,9};
        printNextGreaterElement(arr);
    }

public static void printNextGreaterElement(int[] arr) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(arr[0]);
    for (int i = 1; i < arr.length; i++) {
        while (!stack.isEmpty() && stack.peek() < arr[i]) {
            System.out.println("Next greater element for "
                                + stack.pop() + " = "  + arr[i]);
        }
        stack.push(arr[i]);
    }
    while (!stack.isEmpty()) {
        int top = stack.pop();
        System.out.println(top+ " doesn't have any greater element");
        }
    }
     */
}
