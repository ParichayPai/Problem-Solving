package com.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class makeStringsEqual {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]);
        int X = Integer.parseInt(inp[1]);
        String s1 = br.readLine();
        String s2 = br.readLine();
        StringBuilder s3 = new StringBuilder();
        int cost = 0;
        for(int i=0;i<N;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                s3.append(s1.charAt(i));
            }
        }
        System.out.println(((s3.length()+1)/2)*X);
    }
}
