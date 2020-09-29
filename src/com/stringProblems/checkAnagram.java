package com.stringProblems;

/*
Given two strings a and b consisting of lowercase characters. The
task is to check whether two given strings are an anagram of each
other or not. An anagram of a string is another string that contains
the same characters, only the order of characters can be different.
For example, “act” and “tac” are an anagram of each other.
Input
Input consists of two strings in lowercase english characters.

Constraints:
1 ≤ |s1|, |s2| ≤ 10^5
Output
Print "YES" without quotes if the two strings are anagram else print "NO".

Sample Input
naman
manan

Sample Output
YES

Explanation: Both String contain 2 'a's, 2 'n's and 1 'm'.
 */

import java.util.Arrays;
import java.util.Scanner;

public class checkAnagram {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        char[] ch1 = str1.toCharArray();
        String str2 = sc.nextLine();
        char[] ch2 = str2.toCharArray();
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1!=len2){
            System.out.println("NO");
            return;
        }
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for(int i=0;i<ch1.length;i++){
            if(ch1[i]!=ch2[i]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
