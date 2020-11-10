package com.mathBased;

/*
While doing homework, Nobita stuck on a problem and asks for your help.
Problem statement:-
Given three integers X, Y, and N. Your task is to check if it is possible to form N by using only combinations of X and Y.
i.e check if there exist any P and Q such that P*X + Q*Y = N

Note:- P and Q can be negative
Input
The input contains only three integers X, Y, and N.

Constraints:-
1 <= X, Y, N <= 100000
Output
Print "YES" if it is possible to form N else print "NO".
Sample Input:-
3 5 18

Sample Output:-
YES

Explanation:-
1 * 3 + 3 * 5 = 18 (P = 1, Q = 3)

Sample Input:-
4 8 15

Sample Output:-
NO
 */

import java.util.Scanner;

public class f__kNobita {
    public static int gcd(int x,int y){
        if(y==0){
            return x;
        }
        else{
            return gcd(y,x%y);
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int n=sc.nextInt();
        int gcd = gcd(x,y);
        if(gcd==1){
            System.out.print("YES");
        }
        else if(n%gcd==0){
            System.out.print("YES");
        }
        else{
            System.out.print("NO");
        }
    }
}
