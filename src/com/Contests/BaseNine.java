package com.Contests;

/*
Given a positive integer N. Print the number in base 9 form.
Example for N = 11, in base 9 the number will be 12 (because 1*9 + 2*1 = 11).
Input
Input contains a single integer N.

Constraints:
1 <= N <= 10^18
Output
Print the number in base 9. Note there should not be any trailing 0's.
Example

Sample input
323

Sample output
388
 */

import java.util.Scanner;

public class BaseNine {
    public static void baseConverted(long num){
        StringBuilder ans = new StringBuilder();
        while(num > 0){
            ans.append(num % 9);
            num = num / 9 ;
        }
        for(int i = ans.length()-1 ; i >= 0 ;i--){
            System.out.print(ans.charAt(i));
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        baseConverted(n);
    }
}
