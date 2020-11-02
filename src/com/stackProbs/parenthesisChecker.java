package com.stackProbs;
import java.util.*;
public class parenthesisChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input = sc.next();
        if(n%2==1){
            System.out.println("NO");
            return;
        }
        int count = 0;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
            char c = input.charAt(i);
            if(c=='('||c=='['||c=='{')
                st.push(c);
            else{
                if(st.isEmpty())
                    continue;
                if(c==')' && st.peek()=='('){
                    st.pop();
                    count++;
                }
                if(c==']' && st.peek()=='['){
                    st.pop();
                    count++;
                }
                if(c=='}' && st.peek()=='{'){
                    st.pop();
                    count++;
                }
            }
        }
        if(st.isEmpty() && count==n/2)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}



