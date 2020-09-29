package com.Contests;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContestWays2 {

//    public static long nCr(long n, long r){
////        return nPr(n,r)/(factorial(r));
//        return (factorial(n)/factorial(r)) / factorial(n-r);
////        return fact(n).divide(fact(n.subtract(r))).divide(fact(r));
//    }
//
//    public static long factorial(long r) {
//        long no = 1;
//        for (int i = 2; i < r + 1; i++) {
//            no = (no * i) % 998244353;
//        }
//        return no;
//    }

    static BigInteger nCr(BigInteger n, BigInteger r){
        // System.out.println(fact(r)+" "+n+" "+r);
        // return fact(n).divide((fact(r).multiply(fact(n.subtract(r)))));
        return (fact(n).mod(BigInteger.valueOf(998244353)).divide(fact(n.subtract(r))).mod(BigInteger.valueOf(998244353))); //.multiply(fact(r)));
    }
    // Returns factorial of n
    static BigInteger fact(BigInteger n) {
        if(n.equals(BigInteger.valueOf(1)) || n.equals(BigInteger.valueOf(0)))
            return BigInteger.valueOf(1);
        BigInteger res = BigInteger.valueOf(1);
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n) < 0; i = i.add(BigInteger.valueOf(1)))
            res = res.multiply(i);
        res = res.multiply(n);
        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<BigInteger, BigInteger> map = new HashMap<>();
        int size = sc.nextInt();
        long k = sc.nextLong();
        BigInteger ans = BigInteger.valueOf(0);
        BigInteger count = BigInteger.valueOf(0);
        BigInteger freq = BigInteger.valueOf(1);
        for(int i = 0 ; i < size ; i++){
            BigInteger ele = sc.nextBigInteger();
            if(map.containsKey(ele)){
                map.put(ele,map.get(ele).add(BigInteger.valueOf(1)));

            }
            else{
                count = count.add(BigInteger.valueOf(1));
                map.put(ele,BigInteger.valueOf(1));
            }
        }
        for(Map.Entry<BigInteger , BigInteger> entry : map.entrySet()){
            freq = freq.multiply(entry.getValue());
        }
        //   if(count.compareTo(BigInteger.valueOf(k))== -1 ){
        //       System.out.println("0");
        //   }
        //   else{
        //    System.out.println(count+" "+ans+" "+freq);
//        ans = (nCr(count, BigInteger.valueOf(k)));
//        System.out.println((freq.multiply(ans)).mod(BigInteger.valueOf(998244353)));
        //   }

        System.out.println(map);
        System.out.println(freq);

        BigInteger n = new BigInteger("200");
        BigInteger r = new BigInteger("100");

        BigInteger a = nCr(n,r);
        System.out.println(a.mod(BigInteger.valueOf(998244353)));
        // 24910521

//        for(Map.Entry<BigInteger , BigInteger> entry : map.entrySet()){
//            a = a.divide(entry.getValue());
//            System.out.println(a);
//        }

    }
    // 993339804 (3*2*5*3*7*8*5*3*3*2*5*7*5*5*6*4*2*6*10*5)
}
