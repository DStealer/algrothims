package com.dstealer.algrothims.struct;

import com.dstealer.algrothims.common.Assistant;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void insert() {
        int[] array = Assistant.generateRandomArray(10, 0, 100);
        Assistant.print(array);
        BinarySearchTree bst = new BinarySearchTree();
        for (int k : array) {
            bst.insert(k, -1);
        }
        bst.prePrint();
        bst.midPrint();
        bst.postPrint();

        bst.levelPrint();
    }

    @Test
    public void remove() {
        int[] array = Assistant.generateRandomArray(10, 0, 100);
        Assistant.print(array);
        BinarySearchTree bst = new BinarySearchTree();
        for (int k : array) {
            bst.insert(k, -1);
        }

        bst.levelPrint();
        bst.removeMax();
        bst.levelPrint();
        bst.removeMin();
        bst.levelPrint();
    }

    @Test
    public void removeK() {
        int[] array = new int[]{96, 67, 38, 93, 29, 52, 90, 3};
        Assistant.print(array);
        BinarySearchTree bst = new BinarySearchTree();
        for (int k : array) {
            bst.insert(k, -1);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("\n+++++++++++++ " + array[i]);
            bst.levelPrint();
            bst.removeNode(array[i]);
            System.out.println();
            bst.levelPrint();
        }
    }
}