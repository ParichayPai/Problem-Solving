package com.Contests;

/*
Pino is super fond of candies. Today she has A chocolate candies, B orange candies,
and C unknown candies. You are also given the happiness she gets after eating a
particular candy. She wants to have exactly X chocolate candies and Y orange candies.
She can transform an unknown candy to a candy of any type (chocolate or orange).
Find the maximum happiness she can attain.
Input
First line of input contains 5 integers X, Y, A, B, C.
Second line contains A integers corresponding to the happiness of the various
chocolate candies.
Third line contains B integers corresponding to the happiness of the various
orange candies.
Fourth line contains C integers corresponding to the happiness of the various
unknown candies.

Constraints
1 <= A, B, C <= 100000
1 <= X <= A
1 <= Y <= B
1 <= happiness of any candy <= 1000000000 (10^9)
Output
Output a single integer, the maximum happiness Pino can achieve by eating the candies.
Example

Sample Input
1 2 2 2 1
2 4
5 1
3

Sample Output
12

Explanation
Pino eats the 2nd chocolate candy (happiness=4), then eats the 1st orange
candy (happiness=4+5=9), then transforms the first unknown candy to orange
candy and eats it (happiness=9+3=12)

Sample Input
2 2 2 2 2
8 6
9 1
2 1

Sample Output
25
 */

import java.util.*;

public class CandyProblem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int ptr = x+y;
        long[] arr1 = new long[a];
        long[] arr2 = new long[b];
        long[] arr3 = new long[c];
        List<Long> arrl = new ArrayList<>();
        for(int i=0;i<a;i++)
            arr1[i] = sc.nextInt();
        for(int i=0;i<b;i++)
            arr2[i] = sc.nextInt();
        for(int i=0;i<c;i++)
            arr3[i] = sc.nextInt();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=a-1; i>=0 ;i--){
            if(x--==0)
                break;
            arrl.add(arr1[i]);
        }
        for(int i=b-1; i>=0 ;i--){
            if(y--==0)
                break;
            arrl.add(arr2[i]);
        }
        for(int i=0;i<c;i++)
            arrl.add(arr3[i]);

        long sum=0;
        Collections.sort(arrl);
        // System.out.println(arrl);
        for(int i=arrl.size()-1; i>=0; i--){
            if(ptr--==0)
                break;
            sum += arrl.get(i);
            // System.out.println(ptr+" "+sum);
        }
        System.out.println(sum);
    }
}
