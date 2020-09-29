package com.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class ThreeSpecialTriplets {

    public static long[] minGreater(long[] arr, int size ){
        long[] greater = new long[size];
        greater[size-1] = arr[size-1];
        for (int i = size - 2; i >= 0; i--) {
            greater[i] = Math.max(greater[i+1], arr[i]);
        }
        return greater;
    }

    public static long[] maxLesser(long[] arr, int size){
        long[] lesser = new long[size];

//        This part fails as it is n2 approach
//        lesser[0] = 0;
//        for (int i = 1; i < size; i++) {
//            int ele = 0;
//            for (int j = 0; j < i; j++) {
//                if(arr[j] > ele && arr[j] < arr[i])
//                    ele = arr[j];
//            }
//            lesser[i] = ele;
//        }
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < size; i++){
            set.add(arr[i]);
            if(set.lower(arr[i])!= null)
                lesser[i] = set.lower(arr[i]);
            else
                lesser[i] = 0;
        }
        return lesser;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            long[] arr = new long[n];
            for(int i = 0; i < n; i++)
                arr[i] = Long.parseLong(line[i]);
            long[] greater = minGreater(arr,n);
            long[] lesser = maxLesser(arr,n);
            System.out.println(Arrays.toString(lesser));
            System.out.println(Arrays.toString(greater));

            long answer = -1;
            for(int i = 0; i < n; i++){
                if(lesser[i] < arr[i] && arr[i] < greater[i] && lesser[i]!=0){
                    long value = lesser[i]+(arr[i] * greater[i]);
                    if(value > answer)
                        answer = value;
                }
            }
            System.out.println(answer);
        }
    }
}
    /*
Given an unsorted array A[] of size N. A triplet (i, j, k) is said to be special if
they satisfy below two conditions:

1. i < j < k
2. Ai < Aj < Ak
V(Ai,Aj,Ak): Ai + (Aj * Ak)

You need to find the maximum possible value V(Ai,Aj,Ak) which can be obtained from
possible triplets satisfying above two conditions.
Input
The input line contains T, denoting the number of testcases. Each testcase contains
Two lines. First line contains size of array. Second line contains elements of array
separated by space.

Constraints:
1 <= T <= 100
1 <= N <= 10^5
1 <= A[i] <= 10^6

Sum of N for all test cases is less than 10^5
Output
For each testcase you need find the maximum possible value in new line otherwise
print "-1" if no such triplet is found.

    Sample Input:
    2
    4
    5 20 11 19
    4
    1 2 2 2

    Sample Output:
    214
    -1
     */
