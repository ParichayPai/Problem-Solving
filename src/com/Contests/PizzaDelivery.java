package com.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class PizzaDelivery {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line0 = br.readLine().split(" ");
        int n = Integer.parseInt(line0[0]);
        int m = Integer.parseInt(line0[1]);

        long[] pizza = new long[n];
        String[] line1 = br.readLine().split(" ");
        long[] customer = new long[m];
        String[] line2 = br.readLine().split(" ");


        for (int i = 0; i < n; i++) {
            pizza[i] = Long.parseLong(line1[i]);
        }
        for (int i = 0; i < m; i++) {
            customer[i] = Long.parseLong(line2[i]);
        }

        Arrays.sort(pizza);
        Arrays.sort(customer);

        long ans = findMinTimeToDeliverPizza(pizza, customer);
        System.out.print(ans);
    }

    static long findMinTimeToDeliverPizza(long[] pizza, long[] customer){
        long low = 0;
        long high = Math.abs(pizza[0] - customer[0]) + Math.abs(customer[0] - customer[customer.length - 1]);
        long ans = high;
        while(low <= high){
            long mid = (low + high)/2;
            boolean result = servesAll(mid, pizza, customer);
            if(result){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    static long steps = 0, timeLeft = 0;

    static boolean servesAll(long totalTime, long[] pizza, long[] customer){
        int k = 0; timeLeft = 0;
        for (long l : pizza) {
            steps = 0;
            if (customer[k] < l) {
                steps = Math.abs(l - customer[k]);
                if (steps > totalTime)
                    return false;
                timeLeft = Math.max((totalTime - 2 * steps), (totalTime - steps) / 2);
            } else {
                timeLeft = totalTime;
            }
            while ((l + timeLeft) >= customer[k]) {
                if ((l + timeLeft) < customer[k])
                    break;
                if ((k >= (customer.length - 1)))
                    return true;
                k++;

            }
        }
        return k >= (customer.length - 1);
    }
}
