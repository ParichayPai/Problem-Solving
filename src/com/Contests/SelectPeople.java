package com.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectPeople {

    public static Long[] fact = new Long[1000000];
    public static long p = 1000000007;

    public static void factorial(int n) {
        fact[n] = ((fact[n-1] % p) * (n % p))% p;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        fact[0] = 1L;
        for (int i = 1; i < fact.length-1; i++) {
            factorial(i);
        }

        int american = Integer.parseInt(input[0]);
        int indian = Integer.parseInt(input[1]);
        int r = Math.min(american, indian);

        // summation(1 to min(american, indian))(american C r * indian C r)
        long answer = 0;
        for (int i = 1; i <= r; i++) {
            answer = (answer + nCr(american, i)%p * nCr(indian, i)%p) % p;
        }
        System.out.println(answer);
    }

    public static long nCr(int n, int r) {
        return (fact[n] * inverse(fact[r])%p * inverse(fact[n-r])%p ) %p;
    }

    public static long inverse(long a){
        long result = 1, b = p-2;
        while(b > 0){
            if(b%2!=0){
                result = (result * a) % p;
                b -= 1;
            }else{
                a = (a * a) % p;
                b /= 2;
            }
        }
        return result;
    }
}
