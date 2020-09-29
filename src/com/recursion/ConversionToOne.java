package com.recursion;

import java.util.Scanner;

public class ConversionToOne {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println(ConvertToOne(sc.nextLong(),0));
        }
    }

    public static long ConvertToOne(long no, int count){
        if(no==1)
            return count;
        if(no%2==0)
            return ConvertToOne(no/2, count+1);
        else{
            if(ConvertToOne(no-1, count+1) < ConvertToOne(no+1, count+1))
                return ConvertToOne(no-1, count+1);
            else
                return ConvertToOne(no+1, count+1);
        }
    }
}
