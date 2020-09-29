package com.Contests;

/*
You are given a sequence a1, a2, . . . , an consisting of n integers.
You have to calculate three following values:
1. the number of pairs of indices (l, r) (l ≤ r) such that al · al+1 . . . ar−1 · ar is negative;
2. the number of pairs of indices (l, r) (l ≤ r) such that al · al+1 . . . ar−1 · ar is zero;
3. the number of pairs of indices (l, r) (l ≤ r) such that al · al+1 . . . ar−1 · ar is positive;
Input
The first line contains one integer n — the number of elements in the sequence.
The second line contains n integers a1, a2, . . . , an — the elements of the sequence.

Constraints
1 ≤ n ≤ 200000
−10^9 ≤ ai ≤ 10^9
Output
Print three integers — the number of subsegments with negative product, the number of subsegments
with product equal to zero and the number of subsegments with positive product, respectively.

Sample input
5
5 -3 3 -1 0

Sample output
6 5 4

Sample input
10
4 0 -4 3 1 2 -4 3 0 3

Sample output
12 32 11
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreeProducts {
    public static void threeProducts(int[] arr){
        long positives = 0, zeroes = 0, negatives = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = 1;
            for (int j = i; j < arr.length; j++) {
                current *= arr[j];
                if(current > 0)
                    positives++;
                else if(current < 0)
                    negatives++;
                else{
                    zeroes += arr.length - j;
                    break;
                }
            }
        }
        System.out.println(negatives+" "+zeroes+" "+positives);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            if(Long.parseLong(line[i])>0)
                arr[i] = 1;
            else if(Long.parseLong(line[i])<0)
                arr[i] = -1;
            else
                arr[i] = 0;
        }
        threeProducts(arr);
    }
}
