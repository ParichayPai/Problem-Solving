package com.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CountWays {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] line1 =br.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int K = Integer.parseInt(line1[1]);
        String[] input = br.readLine().split(" ");
        int maxDifficulty = Integer.parseInt(input[1]);
        for(int i = 1; i < input.length;i++){
            int number = Integer.parseInt(input[i]);
            if(maxDifficulty < number)
                maxDifficulty = number;
        }
        int[] freqArr = new int[maxDifficulty+1];
        for (String s : input) {
            int number = Integer.parseInt(s);
            freqArr[number]++;
        }
        int result=findSolution(freqArr,freqArr.length,K,1);
        System.out.println(result);
    }
    public static int findSolution(int[] freqArr,int t,int K,int i){
        if(K > t-i)
            return 0;
        if(K == 0)
            return 1;
        return freqArr[i] * findSolution(freqArr,t,K-1,i+1) + findSolution(freqArr,t,K,i+1);
    }
}

