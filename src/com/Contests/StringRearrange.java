package com.Contests;

/*
Given a string S. You can rearrange its letters in any way you want.
You have to the find the maximum number of substrings in S which are
equal to "abcda" after rearrangement.
Input
First line of input contains a single string S.

Constraints:
1 <= |S| <= 100000
String contains lowercase english letters.
Output
Output a single integer which is the maximum number of substrings in
S which are equal to "abcda" after rearrangement.

Sample Input
cbdaaabcda

Sample Output
2

Explanation : we can rearrange the given string as abcdaabcda
 */

import java.util.*;
class StringRearrange{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int a = 0;
        int b =0;
        int d =0;
        int c =0;
        long count=0;

        char []charArray = str.toCharArray();
        for (char value : charArray) {
            if (value == 'a') {
                a++;
            } else if (value == 'b') {
                b++;
            } else if (value == 'c') {
                c++;
            } else if (value == 'd') {
                d++;
            }

            if (a >= 2 && b >= 1 && c >= 1 && d >= 1) {
                count++;
                a--;
                b--;
                c--;
                d--;
            }

        }

        System.out.println(count);
    }
}