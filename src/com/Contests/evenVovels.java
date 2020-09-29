package com.Contests;

import java.util.Scanner;

public class evenVovels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int count = 0;
        char[] arr = new char[size];
        String st = sc.next();
        arr = st.toCharArray();
        for(int i = 0 ; i < size ; i++){
            if((i+1)%2==0){
                System.out.print(arr[i]);
                count += isVovel(arr[i]);
            }
        }
        System.out.println(count);
    }

    public static int isVovel(char c){
        switch(c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u': return 1;
            default: return 0;
        }
    }
}
