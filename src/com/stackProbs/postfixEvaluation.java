package com.stackProbs;
import java.util.*;
public class postfixEvaluation {
    public static void evalPostfix(String[] pf){
        Stack<Integer> st = new Stack<>();
        for (String s : pf) {
            if (!s.equals("+") && !s.equals("-") && !s.equals("/") && !s.equals("*"))
                st.push(Integer.parseInt(s));
            else {
                int val1 = st.pop();
                int val2 = st.pop();
                switch (s) {
                    case "+":
                        st.push(val2 + val1);
                        break;
                    case "-":
                        st.push(val2 - val1);
                        break;
                    case "/":
                        st.push(val2 / val1);
                        break;
                    case "*":
                        st.push(val2 * val1);
                        break;
                }
            }
        }
        for(Integer i : st){
            System.out.print(i+" ");

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] pf = new String[n];
        for(int i=0;i<n;i++)
            pf[i] = sc.next();
        evalPostfix(pf);
    }
}
