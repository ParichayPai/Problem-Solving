package com.stringProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class numberOfStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        printNumberOfStrings(n);
    }
    public static void printNumberOfStrings(int n) {
        if(n==1){
            System.out.println(0);
        }
//        else {
//
//        }
    }
}
