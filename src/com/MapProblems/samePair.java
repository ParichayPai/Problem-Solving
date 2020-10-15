package com.MapProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Given an array Arr of N integers. Solve the following problem for X from 1 to N :-
Find the number of ways to select a pair (i, j) such that i < j and i != X and j != X and Arr[i] = Arr[j].
Input
First line of input contains a single integer, N.
Second line of input contains N space separated integers, denoting array Arr.

Constraints:
1 <= N <= 100000
1 <= Arr[i] <= N
Output
Print N space separated integers where ith integer is the answer when X = i.
Sample Input
5
4 4 1 1 1

Sample Output
3 3 2 2 2

Explanation:
For X=1 we have (3, 4) (3, 5) (4, 5)
For X=2 we have (3, 4) (3, 5) (4, 5)
For X=3 we have (1, 2) (4, 5)
For X=4 we have (1, 2) (3, 5)
For X=5 we have (1, 2) (3, 4)
 */

public class samePair {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        getSamePair(arr, n);
    }
    // Approach 1 gives TLE O(n3)
//    public static void getSamePair(int[] arr, int n){
//        StringBuilder sb = new StringBuilder("");
//        int X = 0;
//        long count = 0;
//        for (int k = 0; k < n; k++) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (i != X && j != X && arr[i] == arr[j]) {
//                        count++;
//                    }
//                }
//                sb.append(count).append(" ");
//                X++;
//                count = 0;
//            }
//            System.out.println(sb);
//        }
    public static void getSamePair(int[] arr, int n) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        long totalCombinations = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            totalCombinations += (entry.getValue()*(entry.getValue()-1))/2;
        }
        for(int i = 0; i < n; i++){
            long ans = totalCombinations;
            int x = map.get(arr[i]);
            ans -= (x*(x-1))/2;
            x--;
            ans += (x*(x-1))/2;
            System.out.print(ans+" ");
        }
    }
}

