package com.mathBased;

/*
Given N candies of different colours. Find the number of different ways of selecting 1 or more candies such that the number of candies you select is not A or B.
Note - Two selecting ways are different if there is a candy of a particular colour in only one of the selection.
As the answer can be huge print answer 1000000007.
Input
Input contains three integers N A and B.

Constratins:
3 <= N <= 1000000000
1 <= A < B <= min(N, 100000)
Output
Print answer 1000000007.
Sample Input
4 2 4

Sample Output
8

Explanation:
(1) (2) (3) (4) (1, 2, 3) (1, 3, 4) (1, 2, 4) (2, 3, 4)
 */

import java.util.Scanner;

public class candyWays {
    public static long fastPower(long a, long b, long p){
        long res = 1;
        while(b > 0){
            if(b % 2 == 1) {
                res = (res * a) % p;
            }
            b = b / 2;
            a = (a * a) % p;
        }
        return res % p;
    }

    public static long mod(long a, long b, long p) {
        return (a * (fastPower(b,p - 2, p) % p)) % p ;
    }

    public static long nCrModPFermat(long n, long r, long p){
        long ans = 1;
        for(long i = 1; i <= r; i++ ){
            ans = (ans * mod((n - r +i),i,p) % p) % p;
        }
        return ans;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long p = 1000000007;
        long nca = nCrModPFermat(n, a, p);
        long ncb = nCrModPFermat(n, b, p);
        long ans = (fastPower(2,n,p) - nca - ncb - 1 + p + p) % p;
        System.out.print(ans);
    }
}
