package com.AdHocProblems;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void towerOfHanoi(int totalDisks, char fromRod, char toRod, char extraRod){
        if (totalDisks == 1){
            System.out.println(totalDisks+":"+fromRod+"->"+toRod);
        }else {
            towerOfHanoi(totalDisks-1, fromRod, extraRod, toRod);
            System.out.println(totalDisks+":"+fromRod+"->"+toRod);
            towerOfHanoi(totalDisks-1, extraRod, toRod, fromRod);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalDisks = sc.nextInt();
        towerOfHanoi(totalDisks,'A','C','B');
    }
}
