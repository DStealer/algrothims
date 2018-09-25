package com.dstealer.algrothims.sort;

import com.dstealer.algrothims.common.IntegerGenerator;

import java.util.BitSet;


public class BitSetSort {
    public static void main(String[] args) {
        IntegerGenerator generator = new IntegerGenerator(5_0000_0000);
        BitSet bitSet = new BitSet(generator.size());

        try {
            while (true) {
                bitSet.set(generator.gen());
            }
        } catch (IntegerGenerator.StopIteration stopIteration) {
            stopIteration.printStackTrace();
        }

        int indexFrom = 0;
        while (indexFrom <= bitSet.length()) {
            int val = bitSet.nextSetBit(indexFrom);
            System.out.println(val);
            indexFrom = val + 1;
        }
    }
}
