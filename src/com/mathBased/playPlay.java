package com.mathBased;

/*
Solo is playing with numbers from 1 to K. Her small sister Tono comes to her and asks her the following question:
You are given an integer N. You need to create it using the numbers between 1 to K (the numbers you are have), such that you choose multiple instances of only one integer. What are minimum number of instances required to create N?

In simple terms, you need to choose an integer P between 1 to K, such that P * Q = N, and Q is the minimum possible.

Report Q.
Input
The first and the only line of input contains two integers N and K.

Constraints
1 <= N <= 1000000000000
1 <= K <= 1000000000000
Output
Output a single integer the minimum number of instances required to create N.
Sample Input
8 7

Sample Output
2

Explanation
You choose 2 instances of 4.

Sample Input
6 10

Sample Output
1
 */

import java.util.Scanner;

public class playPlay {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        if(k >= n){
            System.out.println(1);
        }
        else{
            long ans = -1;
            long temp = Math.min((long)Math.sqrt(n),k);
            for(int i = 2; i <= temp; i++){
                if(n % i == 0){
                    if(n / i <= k){
                        ans = i;
                        break;
                    } else {
                        ans = n/i;
                    }
                }
            }
            if(ans == -1){
                ans = n;
            }
            System.out.println(ans);
        }
    }
}
