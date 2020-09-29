package com.stackProbs;

/*
You are given a String S. You are allowed to perform following two operations.
1. Remove an element from start of S and add it to the end of B.
2. Remove an element from end of B and add it to the end of A.

Find the lexicographical minimum string A that we can obtain using the above procedure.

Note: The final length of string A must be equal to initial length of string S.
Input
Input contains string S containing only lowercase alphabets.

Constraints
1 <= |S| <= 100000
Output
Print the lexicographical minimum string A that we can obtain.

Input
cab

Output
abc

Input
acdb

Output
abdc
 */

import java.util.*;

public class stringStack {
    public static void printString(StringBuilder s){
        int ptr = 0;
        Stack<Character> B = new Stack<>();
        StringBuilder A = new StringBuilder();
        B.push(s.charAt(ptr));
        ptr++;
        while (ptr<s.length()){
            if(s.charAt(ptr)>B.peek()){
                B.push(s.charAt(ptr));
                ptr++;
            }
            else{
                while (!B.isEmpty() && s.charAt(ptr) < B.peek())
                    A.append(B.pop());

            }
            if(B.isEmpty()) {
                B.push(s.charAt(ptr));
                ptr++;
            }
        }
        while(!B.isEmpty())
            A.insert(0, B.pop());
        System.out.println(A);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder s =  new StringBuilder(sc.next());
        printString(s);
    }
}
/*
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 1, ptr = -1; char ch ='a';
        String s = br.readLine();
        while (s.length() > 0){
            ptr = checkingString(s, i, ch);
            if(ptr != -1){
                for(int j = 0 ; j <= ptr ; j++){
                    while(!st.empty() && st.peek() <= ch)
                        sb.append(st.pop());
                    if(s.charAt(j) == ch)
                        sb.append(s.charAt(j));
                    else
                        st.push(s.charAt(j));
                }
                s = s.substring(ptr+1);
            }
            i++;
            ch++;
        }
        while(!st.empty())
            sb.append(st.pop());
        System.out.print(sb);
    }
    static int checkingString(String s, int i, char ch){
        int ptr = -1;
        for(int j = 0 ; j < s.length() ; j++){
            if(ch == s.charAt(j))
                ptr = j;
        }
        return ptr;
    }
 */
