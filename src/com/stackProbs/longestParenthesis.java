package com.stackProbs;

import java.util.Scanner;
import java.util.Stack;

public class longestParenthesis {
    public static void printLongestParenthesis(String s){
        Stack<int[]> st = new Stack<>();
        int result = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (!st.isEmpty() && st.peek()[0] == 0) {
                    st.pop();
                    int t = 0;
                    if(st.isEmpty())
                        t = -1;
                    else
                        t = st.peek()[1];
                    result = Math.max(result, i - t);
                } else {
                    st.push(new int[]{1, i});
                }
            } else {
                st.push(new int[]{0, i});
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        printLongestParenthesis(input); // ((
    }
}
