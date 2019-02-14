package com.dstealer.algrothims.recursion;

/**
 * 斐波那契数列
 */
public class Factorial {
    public static int calculate(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * calculate(n - 1);
        }
    }
}
