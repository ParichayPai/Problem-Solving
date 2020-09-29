package com.Contests;

/*
You are given two integer arrays A and B of sizes N and M respectively.
You need to modify the elements of A so that B becomes its subarray.
Modifying an element means change the element to any other value.

Find the minimum number of modifications to achieve this.
Input
The first line of the input contains two integers N and M.
The second line of the input contains N space separated integers, the
elements of array A.
The third line of the input contains M space separated integers, the
elements of array B.

Constraints
1 <= M <= N <= 500
1 <= A[i], B[i] <= 10
Output
Output a single integer, the minimum number of modifications in A
to make B its subarray.
Example
Sample Input
6 3
3 1 2 1 3 3
1 2 3

Sample Output
1

Explanation: If you modify A[4] from 1 to 3. A[2].
A[4] represents the array B, so B is its subarray.

Sample Input
10 5
3 4 5 3 4 3 1 3 5 2
1 4 4 4 3

Sample Output
3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubArray {
    public static void Subarray(int[] a, int[] b){
        int n1 = a.length, n2 = b.length, count = n1;
        for(int i = 0; i <= n1-n2; i++){
            int k = n2;
            for(int j = 0; j < n2; j++){
                if(a[i+j]==b[j])
                    k--;
                if(k==0){
                    System.out.println(k);
                    return;
                }
            }
            count = Math.min(count, k);
        }
        System.out.println(count);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");
        String[] line3 = br.readLine().split(" ");
        int a = Integer.parseInt(line1[0]);
        int b = Integer.parseInt(line1[1]);
        int[] aArr = new int[a];
        int[] bArr = new int[b];
        for(int i = 0; i < a; i++)
            aArr[i] = Integer.parseInt(line2[i]);
        for(int i = 0; i < b; i++)
            bArr[i] = Integer.parseInt(line3[i]);
        Subarray(aArr,bArr);
    }
}
