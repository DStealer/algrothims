package com.dstealer.algrothims.miscellane;

public class Overflow {
    /**
     * 无穷
     *
     * @return
     */
    public static double infinity() {
        return 1.0 / 0.0;
    }

    public static int overflow() {
        return Math.abs(1);
    }
}
