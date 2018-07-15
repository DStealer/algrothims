package com.dstealer.algrothims.twinprime;

/**
 * 孪生素数
 */
public class TwinPrime {
    /**
     * 判断一个数是否为素数
     *
     * @param x
     * @return
     */
    public static boolean isPrime(int x) {
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(x); i = i + 2) {
            if (x % i == 0) return false;
        }
        return true;
    }

    /**
     * 判读1至n有多少个孪生素数
     *
     * @param n
     * @return
     */
    public static int twinPrimeNum(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i) && isPrime(i + 2) && (i + 2) <= n) sum++;
        }

        return sum; // 返回个数
    }
}
