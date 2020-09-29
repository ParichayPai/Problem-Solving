package com.stackProbs;
import java.util.*;
public class prefixToInfix {
    public static void calculateInfix(String prefix){
        Stack<String> st = new Stack<>();
        for (int i = prefix.length()-1; i >=0 ; i--) {
            char c = prefix.charAt(i);
            if(c=='+'||c=='-'||c=='/'||c=='*'){
                String  s1 = st.pop();
                String  s2 = st.pop();
                String temp = "("+s1+c+s2+")";
                st.push(temp);
            }else{
                st.push(c+"");
            }
        }
        System.out.println(st.pop());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String prefix = sc.next();
        calculateInfix(prefix); // *-A/BC-/AKL
        // ((A-(B/C))*((A/K)-L))
    }
}
