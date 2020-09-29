package com.Contests;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
You are given an array A consisting of N number and an empty set S.
For each pair of numbers A[i] and A[j] in the array (i < j), you need
to find their LCM and insert the LCM into the set S.

You need to report the GCD of the elements in set S.
Input
The first line of the input contains an integer N.
The second line of the input contains N space separated integers
A[1], A[2],. , A[N].

Constraints
2 <= N <= 100000
1 <= A[i] <= 200000
Output
Output a single integer, the GCD of LCM set S.
Example

Sample Input
4
10 24 40 60

Sample Output
20

Explanation:
The pairwise LCM are as follows:
i : 1 | j : 2 | LCM : 120
i : 1 | j : 3 | LCM : 40
i : 1 | j : 4 | LCM : 60
i : 2 | j : 3 | LCM : 120
i : 2 | j : 4 | LCM : 120
i : 3 | j : 4 | LCM : 120
S = {40, 60, 120}. GCD of the values in S is 20.

Sample Input
2
3 3

Sample Output
3
 */
public class GCDofLCM {
    public static void main (String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        long[] a = new long[n+1];
        long[] gcd = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = sn.nextLong();
            gcd[i] = 1;
        }
        gcd[n-1] = a[n-1];
        for(int i = n-2; i >= 0; i--)  {
            gcd[i] = gcdOfa(a[i], gcd[i+1]);
        }
        Set<Long> set = new HashSet<>();
        for(int i = 0; i < n-1; i++) {
            long lcm = (a[i] * gcd[i+1] / gcdOfa(a[i], gcd[i+1]));
            set.add(lcm);
        }
        long ans = set.iterator().next();
        for(Long i: set) {
            ans = gcdOfa(ans, i);
        }
        System.out.println(ans);
    }
    public static long gcdOfa(long i, long j) {
        return (j == 0) ? i : gcdOfa(j, i % j);
    }
}
