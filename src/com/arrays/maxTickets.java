package com.arrays;

import java.util.Scanner;

public class maxTickets {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long rem = ((n%500)/5)*5;
        long tic = (n-(n%500))*2;
        System.out.println(rem+tic);
    }
}
/*
Given N points. You can get 1000 tickets for 500 points or 5 tickets for 5 points. What is the maximum number of tickets you can earn.
Input
Input contains a single integer N.

Constraints:
1 <= N <= 10^15
Output
Print the maximum number of tickets you can earn using atmax N points.

Sample Input
506

Sample Output
1005

Explanation: we use 500 points to get 1000 tickets and 5 out of remaining 6 points to get 5 tickets making total of 1005 tickets.
 */