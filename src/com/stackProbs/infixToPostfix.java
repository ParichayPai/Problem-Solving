package com.stackProbs;

import java.util.*;

public class infixToPostfix {
    // IMP - Invalid eqn are not dealt with here
    static int precedence(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    public static void printOutput(String infix){
        Stack<Character> st = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for(int i=0;i<infix.length();i++){
            char c = infix.charAt(i);
            if(Character.isLetterOrDigit(c))
                postfix.append(c);
            if(c=='('){
                st.push(c);
            }
            else if(c==')'){
                while(st.peek()!='(')
                    postfix.append(st.pop());
                st.pop();
            }
            else{
                while (!st.isEmpty() && precedence(c)<=precedence(st.peek()))
                    postfix.append(st.pop());
                st.push(c);
            }
            while (!st.isEmpty())
                postfix.append(st.pop());
        }
        System.out.println(postfix);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix = sc.next();
        // eg: ((A-(B/C))*((A/K)-L))
        // Answer - ABC/-AK/L-*
        printOutput(infix);
    }
}

