package com.stackProbs;

/*
The stock span problem is a financial problem where we have a series
of n daily price quotes for a stock and we need to calculate the span
of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum
number of consecutive days just before the given day(including), for which
the price of the stock on the current day is less than or equal to its price
on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

Explanation to the given example:
On 0th day only the current day where we find that stock price is less than
or equal to it so for 1 consecutive day(current day) this happens.
On 1st day only the current day where we find that stock price is less than
or equal to it so for 1 consecutive day(current day) this happens.
On 2nd day only the current day where we find that stock price is less than
or equal to it so for 1 consecutive day(current day) this happens.
Now on 3rd day we observe that stock price for last two consecutive days is
less than or equal to current day i.e. (60, 70) thus count is 2
On 4th day only the current day where we find that stock price is less than
or equal to it so for 1 consecutive day(current day) this happens.
On 5th day we observe that stock price for last four consecutive days is less
than or equal to current day i.e. (60, 70, 60, 75) thus count is 4.
On 6th day we observe that stock price for last six consecutive days is less
than or equal to current day i.e. (80, 60, 70, 60, 75, 85) thus count is 6.
Input
The first line of each test case is N, N is the size of the array. The second
line of each test case contains N input A[i].

1 ≤ N ≤ 100000
1 ≤ A[i] ≤ 100000
Output
For each test case, print the span values for all days.

Input
7
100 80 60 70 60 75 85

Output
1 1 1 2 1 4 6

Input
6
10 4 5 90 120 80

Output
1 1 2 4 5 1

Explanation:
Test case 1:
On 0th day only the current day where we find that stock price is less than
or equal to it so for 1 consecutive day(current day) this happens.
On 1st day only the current day where we find that stock price is less than
or equal to it so for 1 consecutive day(current day) this happens.
On 2nd day only the current day where we find that stock price is less than
or equal to it so for 1 consecutive day(current day) this happens.
Now on 3rd day we observe that stock price for last two consecutive days is
less than or equal to current day i.e. (60, 70) thus count is 2
On 4th day only the current day where we find that stock price is less than
or equal to it so for 1 consecutive day(current day) this happens.
On 5th day we observe that stock price for last four consecutive days is less
than or equal to current day i.e. (60, 70, 60, 75) thus count is 4.
On 6th day we observe that stock price for last six consecutive days is less
than or equal to current day i.e. (80, 60, 70, 60, 75, 85) thus count is 6.
 */

import java.util.Scanner;
import java.util.Stack;

public class stockSpanProblem {
    public static void stockPlan(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        int[] plan = new int[n];
        st.push(0);
        plan[0] = 1;
        for(int i=1;i<n;i++){
            int ele = arr[i];
            while(!st.isEmpty() && arr[st.peek()] <= ele){
                st.pop();
            }
            if(st.isEmpty())
                plan[i] = i+1;
            else
                plan[i] = i - st.peek();
            st.push(i);
        }
        for(int i=0;i<n;i++)
            System.out.print(plan[i]+" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        stockPlan(arr, n);
    }
}
