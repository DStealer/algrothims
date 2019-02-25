package com.dstealer.algrothims.struct;

import java.util.LinkedList;

/**
 * 二分搜索树
 * 性质：节点的左节点均小于该节点，右节点均大于该节点
 * 非完全二叉树 不可有重复元素
 */
public class BinarySearchTree {
    private int count;
    private Node root;

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void insert(int k, Object v) {
        this.root = insert(this.root, k, v);
    }

    /**
     * 插入操作，使用递归
     *
     * @param node
     * @param k
     * @param v
     */
    private Node insert(Node node, int k, Object v) {
        if (node == null) {
            this.count++;
            return new Node(k, v);
        }
        if (k == node.key) {
            node.value = v;
        } else if (k < node.key) {
            node.leftNode = insert(node.leftNode, k, v);
        } else {
            node.rightNode = insert(node.rightNode, k, v);
        }
        return node;
    }

    /**
     * 先序遍历
     */
    public void prePrint() {
        System.out.println("pre order");
        prePrint(this.root);
        System.out.println();
    }

    /**
     * 先打印当前节点
     *
     * @param node
     */
    private void prePrint(Node node) {
        if (node != null) {
            System.out.print(node.key + "\t");
            prePrint(node.leftNode);
            prePrint(node.rightNode);
        }
    }

    public void midPrint() {
        System.out.println("mid order");
        midPrint(this.root);
        System.out.println();
    }

    /**
     * 先打印左节点
     *
     * @param node
     */
    private void midPrint(Node node) {
        if (node != null) {
            midPrint(node.leftNode);
            System.out.print(node.key + "\t");
            midPrint(node.rightNode);
        }
    }

    public void postPrint() {
        System.out.println("post order");
        postPrint(this.root);
        System.out.println();
    }

    /**
     * 先打印右节点
     *
     * @param node
     */
    private void postPrint(Node node) {
        if (node != null) {
            postPrint(node.leftNode);
            postPrint(node.rightNode);
            System.out.print(node.key + "\t");
        }
    }

    public void levelPrint() {
        if (this.root == null)
            return;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.key + "\t");
            if (node.leftNode != null) {
                queue.add(node.leftNode);
            }
            if (node.rightNode != null) {
                queue.add(node.rightNode);
            }
        }
    }

    /**
     * 查找最小节点
     *
     * @return
     */
    public Node findMin() {
        if (this.root == null) {
            return null;
        }
        return minimun(this.root);
    }

    private Node minimun(Node node) {
        if (node.leftNode == null) {
            return node;
        } else {
            return minimun(node.leftNode);
        }
    }

    /**
     * 查找最大值
     *
     * @return
     */
    public Node findMax() {
        if (this.root == null) {
            return null;
        }
        return maxnimum(this.root);
    }

    private Node maxnimum(Node node) {
        if (node.rightNode == null) {
            return node;
        } else {
            return maxnimum(node.rightNode);
        }
    }

    /**
     * 移除最小值
     *
     * @return
     */
    public void removeMin() {
        if (this.root == null) {
            return;
        }
        this.root = removeMin(this.root);
    }

    /**
     * 递归每次返回sbt树的根结点
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) { //一直操作的是node节点
        if (node.leftNode == null) { //相当于移除操作
            this.count--;
            return node.rightNode;
        } else {
            node.leftNode = removeMin(node.leftNode);
            return node;
        }
    }

    /**
     * 移除最大节点
     */
    public void removeMax() {
        if (this.root == null) {
            return;
        }
        this.root = removeMax(this.root);
    }

    private Node removeMax(Node node) { //以node为根的sbt的根结点还是node
        if (node.rightNode == null) { //没有右节点 ，本身最大
            this.count--;
            return node.leftNode;     // 新子树的根节点
        } else {
            node.rightNode = removeMax(node.rightNode);//非最大节点 返回自身
            return node;
        }
    }

    /**
     * 找到子节点的d
     * 找到右子树的最小节点m
     * d->right = delMin(d->right)
     * d->left = m->left
     *
     * @param k
     */
    public void removeNode(int k) {
        this.root = removeNode(this.root, k);
    }

    private Node removeNode(Node node, int k) {
        if (node == null) {
            return null;
        }
        if (k < node.key) {
            node.leftNode = removeNode(node.leftNode, k);
            return node;
        } else if (k > node.key) {
            node.rightNode = removeNode(node.rightNode, k);
            return node;
        } else { // key = k
            if (node.leftNode == null) { //同最小值
                this.count--;
                return node.rightNode;
            }

            if (node.rightNode == null) { //同最大值
                this.count--;
                return node.leftNode;
            }

            Node tn = findMinNode(node.rightNode); // 左右节点均存在
            tn.rightNode = removeMin(node.rightNode);
            tn.leftNode = node.leftNode;
            return tn;
        }
    }

    private Node findMinNode(Node node) {
        while (node.leftNode != null) {
            node = node.leftNode;
        }
        return node;
    }


}

class Node {
    public int key;
    public Object value;
    public Node leftNode;
    public Node rightNode;

    public Node(int key, Object value) {
        this.key = key;
        this.value = value;
        this.leftNode = this.rightNode = null;
    }
}




