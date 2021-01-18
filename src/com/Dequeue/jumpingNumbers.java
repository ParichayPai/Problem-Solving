package com.Dequeue;

/*
Given a positive number X. Find all Jumping Numbers smaller than or equal to X.
Jumping Number: A number is called Jumping Number if all adjacent digits in it differ by only 1. All single-digit numbers are considered as Jumping Numbers. For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.
Input
The first line of the input contains T denoting the number of test cases. Each test case contains a positive number N.

Constraints:
1 <= T <= 50
1 <= N <= 10^8
Output
For each test case, print a single line containing all the Jumping numbers less than or equal to N from 1 in increasing order
Sample Input:
2
10
50

Sample Output:
1 2 3 4 5 6 7 8 9 10
1 2 3 4 5 6 7 8 9 10 12 21 23 32 34 43 45

Explanation:
Testcase 2: Here, the most significant digits of each jumping number is following increasing order, i.e., jumping numbers starting from 0, followed by 1, then 2 and so on, themselves being in increasing order 2, 21, 23.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class jumpingNumbers {
    static long maxNo = 100000000;
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        jumpingNosArr();
        while(t-- > 0) {
            long n = Long.parseLong(br.readLine());
            int i = 0;
            while(n >= list.get(i)){
                System.out.print(list.get(i)+" ");
                i++;
            }
        }
    }

    public static void jumpingNosArr(){
        long i = 1;
        while(i < 10){
            createTree(i);
            i++;
        }
        Collections.sort(list);
    }

    public static void createTree(long num){
        if(num > maxNo)
            return;
        list.add(num);
        long temp = createSmallerNo(num);
        if(temp != -1)
            createTree(temp);
        long temp2 = createLargerNo(num);
        if(temp2 != -1)
        createTree(temp2);
    }

    public static long createSmallerNo(long i){
        if(i%10 == 0)
            return -1;
        return i * 10 + (i % 10 - 1);
    }

    public static long createLargerNo(long i){
        if(i%10+1 == 10)
            return -1;
        return i * 10 + (i % 10 + 1);
    }
}
