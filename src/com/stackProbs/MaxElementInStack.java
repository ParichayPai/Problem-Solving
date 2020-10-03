package com.stackProbs;

import java.util.*;

public class MaxElementInStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Stack<Integer> st = new Stack<Integer>();
        int max = Integer.MIN_VALUE;
        while(size -- > 0){
            int n = sc.nextInt();
            if(n == 1){
                int element = sc.nextInt();
                max = Math.max(max,element);
                st.push(max);

            }
            else if(n == 2){
                if(!st.empty()){
                    st.pop();
                }
                if(st.empty()){
                    max = Integer.MIN_VALUE;
                }
                else{
                    max = st.peek();
                }
            }
            else if(n == 3){
                System.out.println(st.peek());
            }
        }
    }
}
