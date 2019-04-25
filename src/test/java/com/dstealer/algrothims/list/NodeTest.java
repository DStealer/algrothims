package com.dstealer.algrothims.list;

import org.junit.Before;
import org.junit.Test;

public class NodeTest {
    Node head;

    @Before
    public void setUp() throws Exception {
        Node<String> nd = new Node<>(null, "D");
        Node<String> nc = new Node<>(nd, "C");
        Node<String> nb = new Node<>(nc, "B");
        Node<String> na = new Node<>(nb, "A");
        head = na;
    }

    @Test
    public void reverseRecursion() {
        Node recursion = Node.reverseRecursion(head);
        System.out.println(recursion);
    }

    @Test
    public void reverseList() {
        Node reverseList = Node.reverseList(head);
        System.out.println(reverseList);
    }
}