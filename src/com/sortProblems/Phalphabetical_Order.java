package com.sortProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Phalphabetical_Order {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] s = new String[t];
        for(int i = 0 ; i < t ; i++){
            s[i] = br.readLine();
        }
        final String order = "eklpyqrbgjdwtcaxznsifvhmou";
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int pos1 = 0;
                int pos2 = 0;
                for (int i = 0; i < Math.min(o1.length(), o2.length()) && pos1 == pos2; i++) {
                    pos1 = order.indexOf(o1.charAt(i));
                    pos2 = order.indexOf(o2.charAt(i));
                }

                if (pos1 == pos2 && o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }

               return pos1  - pos2;
            }
//        @Override
//        public int compare(String o1, String o2) {
//            return order.indexOf(o1) -  order.indexOf(o2) ;
//        }
        });
        for(int i = 0 ; i < t ; i++)
            System.out.println(s[i]);
    }
}
