package com.AdHocProblems;

/*
You are given 2 numbers a, b.

You an perform at most b steps

In one step :
1- increase a by 3
2- decrease a by 3
3- multiply a by 2

Find number of distinct numbers we can make after performing at most b operations on a.
Input
The first line contains the number of tests T.

For each test case:
Input two integers a and b.

0 < T <= 100
1 <= a <= 100000
1 <= b <= 9
Output
Print answer on a separate line for each test case

Sample Input
2
5 1
30 2

Sample Output
4
11

For test 1:-
In 0 steps, 5 can be formed
In 1 steps 2, 8, 10 can be formed

For test 2:-
in 0 step :- 30
in 1 step- 27 33 60
in 2 step:- 24, 30, 54, 30, 36, 66, 57 63 120

total unique number = 11
 */

import java.util.*;

class DistinctElements{
    static int count = 0;
    public static void distinctNumbers(int a, int b, Set<Integer> set){
        if(b==0)
            return;
        else{
            set.add(a-3);
            distinctNumbers(a-3, b-1, set);
            set.add(a+3);
            distinctNumbers(a+3, b-1, set);
            set.add(a*2);
            distinctNumbers(a*2, b-1, set);
            count = set.size();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            set.add(a);
            distinctNumbers(a,b,set);
            System.out.println(count);
        }
    }
}