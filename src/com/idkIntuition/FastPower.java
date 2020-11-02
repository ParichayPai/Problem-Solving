package com.idkIntuition;

import java.util.*;
class FastPower{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.print(fastPower(x , y));
    }
    static int fastPower(int x , int y){
        int res = 1;
        while(y > 0){
            if(y % 2 != 0){
                res *= x;
                y = y-1;
            }
            else{
                y = y / 2;
                x = x * x;
            }
        }
        return res;
    }
}
