package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Abhi and Niyu play a game where they need to destroy N palaces (numbered through 1 to N)
to pass a level. Abhi performs an attack with frequency p hits per second and Niyu
performs an attack with frequency q hits per second i.e. each character spends fixed
time to raise a weapon and then they hit (the time to raise the weapon is 1/p
seconds for Abhi and 1/q seconds for Niyu). The i-th palace destroys if it receives m
number of hits.

Abhi and Niyu wonder who makes the last hit on each Palace.
If Abhi and Niyu make the last hit at the same time, we assume that both of them have
made the last hit.

Note:- Each castle is to be destroyed individually.
Input
The first line contains three integers N, p, q — the number of palaces, the frequency
of Abhi's and Niyu's attack, correspondingly.
Next N lines contain a single integer m i. e the number of hits required to destroy
the ith palace

Constraints:-
1≤m≤109
1≤N≤105
1≤p, q≤ 106
Output
Print n lines. In the i-th line print word "Abhi", if the last hit on the i-th palace
was performed by Abhi, "Niyu", if Niyu performed the last hit, or "Both", if both
performed it at the same time.

Sample Input:-
4 3 2
1
2
3
4

Sample Output:-
Abhi
Niyu
Abhi
Both

Explanation:-
In the first sample Abhi makes the first hit at time 1/3, Niyu makes the second
hit at time 1/2, Abhi makes the third hit at time 2/3, and both boys make the fourth
and fifth hit simultaneously at the time 1.

Sample Input:-
2 1 1
1
2

Sample Output:-
Both
Both

 */

public class AbhiNiyu {
    static String[] answer = new String[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int size = Integer.parseInt(line1[0]);
        long abhi = Integer.parseInt(line1[1]);
        long niyu = Integer.parseInt(line1[2]);

        answer[0] = "Both";
        long[] castle = new long[size];
        long max = 0;
        for(int i = 0 ; i < size ; i++) {
            castle[i] = Long.parseLong(br.readLine());
            max = Math.max(castle[i], max);
        }

        StringBuilder sb = new StringBuilder();
        int last =  findWinner(abhi, niyu, max);
        for(int i = 0 ; i < size ; i++){
            sb.append(answer[(int) (castle[i] % last)]).append("\n");
        }

        System.out.println(sb);
    }


    static int findWinner(long abhi, long niyu, long basePower){

        long temp = basePower + 1;
        long i = 1, j = 1;
        int itr = 1;
        while(temp > itr){
            if(i*niyu < j*abhi){
                basePower--;
                answer[itr] = "Abhi";
                i++;
                itr++;
            }
            else if(i*niyu > j*abhi){
                answer[itr] = "Niyu";
                basePower--;
                j++;
                itr++;
            }
            else{
                answer[itr] = "Both";
                itr++;
                answer[itr] = "Both";
                break;
            }

        }
        return itr ;
    }
}
