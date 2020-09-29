package com.stackProbs;

/*
Given n non-negative integers representing an elevation map where
the width of each bar is 1, compute volume of water it is able to
trap after raining.
Please refer to Sample test case for more details.

Input
The first line of input contains the size of the array, n
The following line of input contains n space-separated integers

Constraints:-
1 <= n <= 50000
0<=A[i]<=1010
Output
The first and only line of output contains integer, in accordance to the task.

Sample Input:
6
3 0 0 2 0 4
Sample Output:
10

 */

import java.util.*;

public class waterTrappingStack {
    public static void printTrappedWater(long[] heights, int n){
        Stack<Integer> st = new Stack<>();
        long distance = 0, boundedHeight = 0, totalWater = 0;
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && heights[i]>heights[st.peek()]){
                int top = st.pop();
                if(st.isEmpty())
                    break;
                distance = i - st.peek() - 1;
                boundedHeight = Math.min(heights[i],heights[st.peek()]) - heights[top];
                totalWater += boundedHeight*distance;
            }
            st.push(i);
        }
        System.out.print(totalWater);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] heights = new long[n];
        for(int i=0;i<n;i++)
            heights[i] = sc.nextLong();
        printTrappedWater(heights,n);
    }
}
