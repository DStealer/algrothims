package com.dstealer.algrothims.list;

/**
 * 反转单链表
 *
 * @param <T>
 */
public class Node<T> {
    Node next;
    T obj;

    public Node(Node next, T obj) {
        this.next = next;
        this.obj = obj;
    }

    public static Node reverseRecursion(Node node) {
        if (node == null || node.next == null) {
            return node;
        } else {
            Node next = node.next;
            Node h = reverseRecursion(node.next);
            next.next = node;
            node.next = null;
            return h;
        }
    }

    public static Node reverseList(Node node) {
        Node pre = null;
        Node next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", obj=" + obj +
                '}';
    }
}
