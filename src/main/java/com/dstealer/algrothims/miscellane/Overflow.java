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

    /**
     * 溢出 int类型最小值
     *
     * @return
     */
    public static int overflow() {
        return Math.abs(-2147483648);
    }
}
