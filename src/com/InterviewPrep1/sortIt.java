package com.InterviewPrep1;

/*

Given an array of N integers containing only 0 or 1. You can do following operations on the array:
> swap elements at two indices.
> choose one index and change its value from 0 to 1 or vice- versa.
You have to do minimum number of above operations such that the final array is non-decreasing.
Input
First line of input contains a single integer N.
Second line of input contains N space separated integers denoting the array.

Constraints:
1 <= N <= 100000
elements of the array are 0 or 1.
Output
Minimum number of moves required such that the final array is non- decreasing.
Sample Input 1
5
1 1 0 0 1

Sample Output 1
2

Explanation:
Swap indices (1, 3)
Swap indices (2, 4)

Sample Input 2
5
0 0 1 1 1

Sample Output 2
0

Sample Input 3
5
0 1 0 1 1

Sample Output 3
1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sortIt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] arr = new int[n];

        boolean decreasingOrder = false;

        int totalZeroCount = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
            if(i != 0 && arr[i] < arr[i - 1])
                decreasingOrder = true;
            if(arr[i] % 2 == 0)
                ++totalZeroCount;
        }

        if(!decreasingOrder) {
            System.out.println("0");
        } else {
            int oneCount = 0;

            for(int i = 0; i < totalZeroCount; i++) {
                if(arr[i] == 1)
                    ++oneCount;
            }
            System.out.println(oneCount);
        }
    }
}
