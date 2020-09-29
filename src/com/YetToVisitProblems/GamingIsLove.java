package com.YetToVisitProblems;

/*
Aniket and Swapnil are playing a game in which they have two piles of stones
with N1 and N2 stones respectively. They take turns picking any even positive
number of stones from one of the pile and keep half of them on the other pile
and throw away the other half. Whoever can not make a move loses. Given N1 and
N2 find who will win. Swapnil makes the first move.
Input
The first and only line of input contains two integers N1 and N2.

Constraints
1 <= N1, N2 <= 1000000000000000
Output
Print "Swapnil" if Swapnil wins the game and print "Aniket" if Aniket wins the game.

Sample Input 1
2 1

Sample Output 1
Aniket

Sample Input  2
4 8

Sample Output 2
Swapnil
 */

import java.math.BigInteger;
import java.util.Scanner;

public class GamingIsLove {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger p1 = sc.nextBigInteger();
        BigInteger p2 = sc.nextBigInteger();

        if(p1.subtract(p2).equals(BigInteger.valueOf(1)) || p1.subtract(p2).equals(BigInteger.valueOf(-1)) || p1.subtract(p2).equals(BigInteger.valueOf(0)) )
            System.out.println("Aniket");
        else
            System.out.println("Swapnil");
    }
}
