package com.stringProblems;

/*
Given a string S of length N. Find a string R of length N such that hamming
distance between S and R is 1 and R is lexicographically smallest possible.
Input
Input contains a single string S containing english lowercase alphabets.

Constraints:
1 <= |S| <= 100000
Output
Print a single string R, such that R contains english lowercase letters only.
Sample Input
aba

Sample Output
aaa

Explanation: hamming distance between aba and aaa = 1 and aaa is lexicographically
smallest such string.

Sample Input
a

Sample Output
b
 */

import java.util.Arrays;
import java.util.Scanner;

public class HammingDistance {
    public static void hammingDistance(String s1){
        String s2 = s1;
        int p = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s2.charAt(i) != 'a') {
                s2 = s2.substring(0,i)+'a'+s2.substring(i+1);
                p++;
                if (p == 1)
                    break;
            }
        }
        String s = "";
        if(s1.equals(s2)){
            s = (char)(s2.charAt(0)+1) + s2.substring(1);
            char[] c = s.toCharArray();
            Arrays.sort(c);
            System.out.println(c);
            return;
        }
        System.out.println(s2);
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        hammingDistance(s);
    }
}
