package com.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EnemyBase {

    public static long[] dayZero(long power, long[] base){
        long[] dayOneArray = new long[base.length];
        for (int i = 0; i < base.length; i++) {
            if(base[i] > power)
                dayOneArray[i] = base[i];
            else
                dayOneArray[i] = 0;
        }
        return dayOneArray;
    }

    public static boolean attack(int size, long power, long[] base, int days){
        long[] destruction = dayZero(power, base);
        System.out.println(Arrays.toString(destruction));
        int day = 1;
        long[] copy = new long[size];
        System.arraycopy(destruction, 0, copy, 0, size);
        while (day <= days){
            int zeroCount = 0;
//            System.out.println(Arrays.toString(destruction)+"dest"+power+" "+day);
            for (int i = 0; i < size; i++) {
                if(destruction[i] == 0){
                    copy[i] = 0;
                    if(i-day >= 0){
                        copy[i-day] = Math.max(0, destruction[i-day] - power);
                        destruction[i-day] =  Math.max(0, destruction[i-day] - power);
                    }
                    if(i+day <= size-1){
                        copy[i+day] =Math.max(0, destruction[i+day] - power);
                        destruction[i+day] =  Math.max(0, destruction[i+day] - power);
                    }
                }
                System.out.println(i+" "+Arrays.toString(copy)+" copy "+power+" "+day);
            }
//            if (size >= 0) System.arraycopy(copy, 0, destruction, 0, size);
            for (int i = 0; i < size; i++) {
                if(copy[i] == 0)
                    zeroCount++;
            }
            if(zeroCount == size)
                return true;
//            System.arraycopy(copy, 0, destruction, 0, size);
            day++;
        }
        for (int i = 0; i < size; i++) {
            if(copy[i] != 0)
                return false;
        }
        return true;
    }

    public static void enemyBaseBinarySearch(long low, long high, int d, long[] base){
        long ans = 100000000;
        while (low <= high) {
            long mid = (low + high) / 2;
            boolean tempAnswer = attack(base.length, mid, base, d);
            if (tempAnswer) {
                if(mid < ans) {
                    ans = mid;
                }
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int d = Integer.parseInt(line1[1]);
        long[] base = new long[n];
        long max;
        long min = max = Long.parseLong(line2[0]);
        for(int i = 0; i < n; i++){
            base[i] = Long.parseLong(line2[i]);
            min = Math.min(min, base[i]);
            max = Math.max(max, base[i]);
        }
        enemyBaseBinarySearch(min, max, d, base);
    }
}
/*
The government has launched a missile to destroy the enemy bases which
are represented by a 1-indexed array of N integers.
At the time of launch, all the enemy bases which have defense lower than
or equal to A will be destroyed immediately. Then after, each destroyed
defense will act as government source and will lower the enemy base defense
by A when it attacks any particular base. If the current base is i (1 <= i < = N)
then on the first day it will attack i+1 and i-1 base the next day it will attack
the i+2 and i-2 base (the attack happens only if a base exists at the attack position).
The base will be destroyed if its defense goes below or equal to 0.
Since the missile is costly, the government wants to know the minimum A
requires so that the project can be ended within D days.
For more clarification see the example
Note:- Only the defenses which were destroyed at the time of launch will
act as a source
Input
First line of input contains two space separated integer N and D. Second
line of input contains N space separated integers denoting the value of the Array.

Constraints:-
1 < = N < = 100000
1 < = Arr[i] < = 100000000
1 < = D < = 10000
Output
Print the minimum attack power requires to complete the project within D days.

Sample Input:-
3 1
5 10 5

Sample Output:-
5

Explanation:-
1st and 3rd defense will be destroyed immediately then at first day
1st will attack 2nd defense and lowers its defense by 5 and on the
same day 3rd defense will also attack the second and destroys it.

Sample Input:-
6 3
2 15 4 2 6 9

Sample Output:-
5

Explanation:-
After launch :- 0 15 0 0 6 9 (1st 3rd and 4th will act as source)
Day 1:- 0 5 0 0 1 9
Day 2:- 0 0 0 0 0 4
Day 3:- 0 0 0 0 0 0
 */