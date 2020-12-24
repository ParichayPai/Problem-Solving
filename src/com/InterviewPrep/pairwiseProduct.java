package com.InterviewPrep;

import java.util.Scanner;

public class pairwiseProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = 0, sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (i-1);
            ans += (sum*i);
            ans %= 1000000007;
        }
        System.out.println(ans);
    }
}
