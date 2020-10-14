package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class closestBuddy {
    public static int gcd(int a, int b) {
        if (a == 0){
            return b;
        }
        return gcd(b%a, a);
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s =br.readLine().split(" ");
        int[] arr =new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(s[i-1]);
        }
//        int[] result = new int[n+1];
//        for (int i = 1; i <= n; i++) {
//            int leftIndex = checkLeft(arr);
//            int rightIndex = checkRight(arr);
//            if(leftIndex!=-1 && )
//            result[i] =
//            if(result[i]==0){
//                result[i] = -1;
//            }
//        }
//        System.out.println(Arrays.toString(result));
        int[] tempArray = new int[51];
        int[] resultArray = new int[n+1];
        for(int i = 1; i <= n; i++){
            tempArray[arr[i]] = i;
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= 50; j++){
                if(tempArray[j]==0){
                    continue;
                }
                if(gcd(j,arr[i])==1){
                    int abs = Math.abs(i - tempArray[j]);
                    if(min > abs){
                        min = abs;
                        resultArray[i] = tempArray[j];
                    }
                }
            }
            if(min==Integer.MAX_VALUE){
                resultArray[i] = -1;
            }
        }
        tempArray = new int[51];
        for(int i = n; i >= 1; i--){
            tempArray[arr[i]] = i;
            for(int j = 1; j <= 50; j++){
                if(tempArray[j]==0){
                    continue;
                }
                if(gcd(j,arr[i])==1){
                    if(resultArray[i]==-1){
                        resultArray[i] = tempArray[j];
                    }
                    else{
                        if(Math.abs(i-tempArray[j]) < Math.abs(i-resultArray[i])){
                            resultArray[i] = tempArray[j];
                        }
                    }
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            System.out.print(resultArray[i]+" ");
        }
    }
}

/*
You are given an integer array A of size N. For each index i (1 <= i <= N), you need to find an index j, such that gcd(A[i], A[j]) = 1, and abs(i-j) is the minimum possible. If there are two values of j satisfying the condition, report the minimum one. If there is no possible value of j, report -1.

Note: gcd(x, y) represents the the greatest common divisor of integers x and y, while abs(i- j) represents the absolute value of (i-j). Eg: gcd(6, 15) = 3 ; abs(6-15) = 9.

See sample for better understanding.
Input
The first line of the input contains a single integer N.
The next line of the input contains N space separated integers, the elements of the array A.

Constraints
1 <= N <= 200000
1 <= A[i] <= 50
Output
Output N space separated integers, the value of j corresponding to each index. If there is no possible value of j, report -1 instead.
Example
Sample Input
5
1 2 4 3 9

Sample Output
1 1 4 3 3

Explanation
For index 1, gcd(A[1], A[1]) = 1, and abs(1-1) = 0.
For index 2, gcd(A[2], A[1]) = 1, and abs(2-1) = 1. gcd(A[2], A[4) is also equal to 1, but abs(2-4) = 2, which is a greater value.
Similarly for index 3, 4, and 5, gcd(A[3], A[4]) = 1, gcd(A[4], A[3]) = 1, and gcd(A[5], A[3]) = 1.

Sample Input
5
3 3 2 3 3

Sample Output
3 3 2 3 3

Sample Input
5
3 21 7 7 21

Sample Output
3 -1 1 1 -1

 */