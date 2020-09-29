package com.Contests;

/*
We define a number A as a good integer if:
the number of divisors (excluding 1 and the number itself) of A is greater
than 0 and the divisors would be in consecutive sequence when arranged in
sorted order
Given a number N, calculate the number of good integers less than or equal to N.
Input
The input contains a single integer N.

Constraints:
1 <= N <= 109
Output
Print the number of good integers less than or equal to N.

Sample Input:-
4

Sample Output:-
1

Sample Input:-
9

Sample Output:-
3

Explanation:- 4 6 9 are the only good integers

 */

import java.util.Scanner;

public class goodIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long input = sc.nextLong();
        int i = 2, sum = 0;
        double inputSqrt = Math.sqrt(input);
        while(i <= inputSqrt){
            if(checkForPerfectSquare(i))
                sum++;
            i++;
        }
        if(input >= 6)
            System.out.print(sum + 1);
        else
            System.out.print(sum);
    }

    static boolean checkForPerfectSquare(int i){
        int count = 0;
        for(int j = 2; j <= i; j++){
            if(i % j == 0)
                count++;
        }
        return count == 1;
    }
}
