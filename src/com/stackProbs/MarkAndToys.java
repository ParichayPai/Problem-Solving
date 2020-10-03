package com.stackProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MarkAndToys {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Long> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            String[] inp = br.readLine().split(" ");
            int opr = Integer.parseInt(inp[0]);
            if(opr == 1){
                long ele = Long.parseLong(inp[1]);
//                if(st.isEmpty()){
                    st.push(ele);
//                }else{
//                    if(st.peek() > ele){
//                        long temp = st.pop();
//                        st.push(ele);
//                        st.push(temp);
//                    }else{
//                        st.push(ele);
//                    }
//                }
            }else if(opr == 2){
                st.pop();
            }else {
                printMaxElementInStack(st);
            }
        }
    }
    public static void printMaxElementInStack(Stack<Long> st){
        List<Long> arrl = new ArrayList<>();
        while(!st.isEmpty()) {
            arrl.add(st.pop());
        }
        Collections.sort(arrl);
        for(Long ele: arrl){
            st.push(ele);
        }
        System.out.println(st.peek());
    }
}
