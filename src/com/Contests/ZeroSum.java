package com.Contests;

/*
Given an integer N, your task is to print an array of N elements such that:-
* Their sum is 0
* All elements are distinct
* Difference between maximum and minimum element of the array should be smallest
Input
Input contains a single integer N.

Constraints:-
1 < = N < = 100000
Output
Print the lexicographically smallest array possible.
i.e Suppose your ans is {1 -1 2 -2 } then lexicographically smallest array will be {-2 -1 1 2}

Sample Input:-
3

Sample Output:-
-1 0 1

Sample Input:-
2

Sample Output:-
-1 1
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ZeroSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        int no = sc.nextInt();
        if(no%2!=0)
            arrl.add(0);
        for(int i=1;i<no;++i){
            arrl.add(i);
            arrl.add(-i);
            if(arrl.size()==no)
                break;
        }
        Collections.sort(arrl);
        for (Integer integer : arrl)
            System.out.print(integer + " ");
    }
}
