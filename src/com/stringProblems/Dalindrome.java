package com.stringProblems;

/*
Everyone has heard of palindromes, right! A palindrome is a string that
remains the same if reversed.
Let's define a new term, Dalindrome.
A Dalindrome is a string whose atleast one of the substrings is a palindrome.
Given a string, find whether it's a Dalindrome.
Input
The only line of input contains a string to be checked.

Constraints
1 <= length of string <= 100
Output
Output "Yes" if string is a Dalindrome, else output "No".

Sample Input
cbabcc

Sample Output
Yes

Explanation: "bab" is one of the substrings of the string that is a
palindrome. There may be other substrings that are palindrome as well
like "cc", or "cbabc". The question requires atleast one.
 */

import java.util.Scanner;

public class Dalindrome {
    public static boolean checkPalindrome(String s){
        StringBuilder s2 = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            s2.append(s.charAt(i));
        }
        return s2.toString().equals(s);
    }
    public static boolean dalindrome(String input){
        for (int i = 0; i < input.length(); i++) {
            for (int j = i+1; j < input.length(); j++) {
                String s = input.substring(i,j);
                if(s.length()>1)
                    if(checkPalindrome(s))
                        return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if(dalindrome(input)|| input.length()==1)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
