package com.Contests;

/*
Given a string S. Find number of pairs of substrings which are equal.
Input
Input contains a string S containing lowercase english alphabet.

Constraints:
1 <= |S| <= 500
Output
Print number of pairs of substrings which are equal.
 */

import java.util.*;

public class equalSubstrings {
    public static void printSubStrings(String s){
        Map<String, Long> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i,j+1);
                map.put(sub, map.getOrDefault(sub,(long)0)+(long)1);
            }
        }
        long count = 0;
        for(Map.Entry<String, Long> entry: map.entrySet()){
            if(entry.getValue()>1){
                count += nC2(entry.getValue());
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        printSubStrings(s);
    }
    static long nC2(long n){
        return (n*(n-1))/2;
    }
}
