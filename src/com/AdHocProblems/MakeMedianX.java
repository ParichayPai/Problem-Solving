package com.AdHocProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeMedianX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String[] n_x = br.readLine().split(" ");
            int n = Integer.parseInt(n_x[0]);
            int x = Integer.parseInt(n_x[1]);
            String[] input = br.readLine().split(" ");
            int lessThan = 0, moreThan = 0, equal = 0;
            int maxLess = Integer.MIN_VALUE;
            int minGreater = Integer.MAX_VALUE;
            int result;
            for(int i = 0; i < n; i++){
                int number = Integer.parseInt(input[i]);
                if(number < x){
                    lessThan++;
                    if(number > maxLess)
                        maxLess = number;
                }
                else if(number > x){
                    moreThan++;
                    if(number < minGreater)
                        minGreater = number;
                }
                else
                    equal++;
            }
            int absDiff = Math.abs(lessThan - moreThan);
            if(equal > 0){
                if(absDiff < equal)
                    result = 0;
                else if(absDiff == equal)
                    result = 1;
                else
                    result = absDiff - equal + 1;
            }
            else{
                if(absDiff > 0){
                    if(moreThan > lessThan && (((2*x)-minGreater) >= maxLess))
                        result = absDiff;
                    else if(lessThan > moreThan && (((2*x)-maxLess) <= minGreater))
                        result = absDiff;
                    else
                        result = absDiff+1;
                }
                else{
                    if((maxLess + minGreater)/2 == x)
                        result = 0;
                    else
                        result = 1;
                }
            }
            System.out.println(result);
        }
    }
}

/*
Logic is to find no max on right and just less on left
 */
