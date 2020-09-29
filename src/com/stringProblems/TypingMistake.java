package com.stringProblems;

/*
In the fairyland, there are two kinds of keyboard layouts, T1 and T2.
The keyboards are exactly similar except for the position of letters.

You are given two strings consisting of 26 distinct letters each: all
keys of the first and the second layouts are same.

You are also given some text consisting of small and capital English
letters and digits. It is known that it was typed in the first layout,
but the writer intended to type it in the second layout. Print the text
if the same keys were pressed in the second layout.

Since all keys but letters are the same in both layouts, the capitalization
of the letters should remain the same, as well as all other characters.

(See Sample Test Case for better understanding)
Input
The first line contains a string of length 26 consisting of distinct
lowercase English letters. This is the first layout.
The second line contains a string of length 26 consisting of distinct
lowercase English letters. This is the second layout.
The third line contains a non-empty string s consisting of lowercase
and uppercase English letters and digits. This is the text typed in
the first layout.

Constraints:-
1 <= |s| <= 500
Output
Print the text on pressing the keys from the second layout.

Sample Input:-
qwertyuiopasdfghjklzxcvbnm
veamhjsgqocnrbfxdtwkylupzi
FpcpEbb2019

Sample Output:-
BoloApp2019

Explanation:-
f->b
p->o
c->l
e->a
b->p
by these operation modified string becomes BoloApp2019
 */

import java.util.Scanner;

public class TypingMistake {
    public static void typingMistake(String pattern1, String pattern2, String input){
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(Character.isLetter(c)){
                int index = pattern1.indexOf(Character.toLowerCase(c));
                if(Character.isUpperCase(c)){
                    output.append(Character.toUpperCase(pattern2.charAt(index)));
                }else{
                    output.append(pattern2.charAt(index));
                }
            }else{
                output.append(c);
            }
        }
        System.out.println(output);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern1 = sc.next();
        String pattern2 = sc.next();
        String input = sc.next();
        typingMistake(pattern1, pattern2, input);
    }
}
