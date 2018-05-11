package com.dstealer.algrothims.swapint;

import com.dstealer.algrothims.common.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwapInt {
    private static final Logger LOGGER = LoggerFactory.getLogger(SwapInt.class);

    /**
     * @param i1
     * @param i2
     * @return
     */
    public static Pair<Integer> swapInt_1(int i1, int i2) {
        int m = i1;
        LOGGER.debug("m:{} i1:{} i2:{}", m, i1, i2);
        i1 = i2;
        LOGGER.debug("m:{} i1:{} i2:{}", m, i1, i2);
        i2 = m;
        LOGGER.debug("m:{} i1:{} i2:{}", m, i1, i2);
        return new Pair<>(i1, i2);
    }

    /**
     * 使用运算
     *
     * @param i1
     * @param i2
     * @return
     */
    public static Pair<Integer> swapInt_2(int i1, int i2) {
        i1 = i1 + i2;
        LOGGER.debug("i1:{} i2:{}", i1, i2);
        i2 = i1 - i2;
        LOGGER.debug("i1:{} i2:{}", i1, i2);
        i1 = i1 - i2;
        LOGGER.debug("i1:{} i2:{}", i1, i2);
        return new Pair<>(i1, i2);
    }

    /**
     * 使用位运算
     *
     * @param i1
     * @param i2
     * @return
     */
    public static Pair<Integer> swapInt_3(int i1, int i2) {
        LOGGER.debug("i1:{} i2:{}", Integer.toBinaryString(i1), Integer.toBinaryString(i2));
        i1 = i1 ^ i2;
        LOGGER.debug("i1:{} i2:{}", Integer.toBinaryString(i1), Integer.toBinaryString(i2));
        i2 = i1 ^ i2;
        LOGGER.debug("i1:{} i2:{}", Integer.toBinaryString(i1), Integer.toBinaryString(i2));
        i1 = i1 ^ i2;
        LOGGER.debug("i1:{} i2:{}", Integer.toBinaryString(i1), Integer.toBinaryString(i2));
        return new Pair<>(i1, i2);
    }
}
