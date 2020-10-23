package com.stringProblems;

/*
A string is called beautiful if it can be represented by two or more consecutive numbers. Given a string S check if it is beautiful or not.

Note:- The numbers should not contain leading zeroes in it i. e string "10203" ("1" + "02" + "03") will not be treated as a beautiful string
Input
Input contains a single string containing the string S.

Constraints:-
1 <= |S| <= 32
Output
Print "YES" if the given string is beautiful and print the first number of the sequence else print "NO".
Sample Input:-
101112

Sample Output:-
YES 10

Explanation:-
Given string can be broken as "10" + "11" + "12"

Sample Input:-
101111

Sample Output:-
NO
 */
import java.util.Scanner;

public class beautifulStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        beautiful(s);
    }

    static void beautiful(String s) {
        int len = s.length();
        StringBuilder s1;

        long temp;
        for (int i = 1; i <= len / 2; i++) {
            s1 = new StringBuilder(s.substring(0, i));
            temp = Long.parseLong(s1.toString()) + 1;

            while (s1.length() <= s.length()) {
                s1.append(temp);
                temp++;
                if (s1.toString().equals(s)) {
                    System.out.println("YES " + s.substring(0, i));
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}
