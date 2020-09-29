package com.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSegments {
    // O(n) solution
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] line;
        int left, right;

        long[] store = new long[200002];

        for(int i = 0 ; i < t ; i++){
            line = br.readLine().split(" ");
            left = Integer.parseInt(line[0]);
            right = Integer.parseInt(line[1]);
            store[left]++;
            store[right + 1]--;
        }
        System.out.println(Arrays.toString(store));
        long max = 0, sum = 0;
        for(int i = 0 ; i < 200002 ; i++){
            sum += store[i];
            max = Math.max(sum, max);
        }
        System.out.print(max);
    }
    /* O(n2) Solution
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] line;
        int left, right;

        long[] store = new long[200002];

        for(int i = 0; i < t; i++){
            line = br.readLine().split(" ");
            left = Integer.parseInt(line[0]);
            right = Integer.parseInt(line[1]);
            for(int j = left; j <= right; j++){
                store[j]++;
            }
        }
        long max = 0;
        for(int i = 0; i < store.length; i++){
            max = Math.max(max, store[i]);
        }
        System.out.println(max);
	}
     */
}
