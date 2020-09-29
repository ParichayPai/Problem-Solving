package com.Contests;

import java.util.Scanner;

public class longestSubstring {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        int zero = 0;
        int one = 0;
        String[] str = sc.nextLine().split("");
        for(int i=0;i<n;i++){
            arr[i] = isVowel(str[i]);
            if(arr[i]==0){
                zero++;
            }
            else {
                one++;
            }
        }
        if(zero <= k){
            System.out.println(n);
        }else{
            int start = 0;
            int end = 0;
            int maxlen = 0;
            for(int i = 0; i < n; i++){
                if(arr[i] == 0){
                    end++;
                }
                while(end>k){
                    if(arr[start]==0){
                        end--;
                    }
                    start++;
                }
                maxlen = Math.max(maxlen,i-start+1);
                //System.out.println(maxlen+" "+start+" "+end);
            }
            System.out.println(maxlen);

        }

    }
    public static int isVowel(String c){
        switch(c){
            case "a":
            case "e":
            case "i":
            case "o":
            case "u": return 1;
            default: return 0;
        }
    }
}
