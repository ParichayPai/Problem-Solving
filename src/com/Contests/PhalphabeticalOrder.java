package com.Contests;

/*
The phalphabetical order of the english alphabets is: "eklpyqrbgjdwtcaxznsifvhmou".
This means that in phalphabetical order, 'e' is the first character, 'k' is the
second character and so on.
Given some strings arrange them in phalphabetical order.
Input
The first line contains a single integer N denoting the number of strings. The
next N line contains strings containing lowercase English characters.

1 <= N <= 100
1 <= length of strings <= 100
Output
Print N lines containing the strings arranged in phalphabetical order.

Sample Input:
4
is
newton
school
fun

Sample Output:
newton
school
is
fun

Explanation:
It is clear from the phalphabetical order that 'n' occurs first, then 's',
then 'i' and then 'f'.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class PhalphabeticalOrder {
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

                return pos1  - pos2  ;
            }
        });
        for(int i = 0 ; i < t ; i++)
            System.out.println(s[i]);
    }
}
