package com.recursion;

import java.util.Scanner;

public class PowerFunction {
    public static double powerFunction(double no, int power){
        if(power==0)
            return 1;
        else if(power>0){
            return no * powerFunction(no,--power);
        }
        else{
            return 1/no * powerFunction(no,++power);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            double no = sc.nextDouble();
            int power = sc.nextInt();
            double answer = powerFunction(no, power);
            System.out.printf("%.2f",answer);
        }
    }
}
