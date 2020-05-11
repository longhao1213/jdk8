package com.jdk.tree;


/**
 * Copyright (C), 2006-2010, ChengDu longsan info. Co., Ltd.
 * FileName: RedBlackTree.java
 * 红黑树实现
 * @author lh
 * @version 1.0.0
 * @Date 2020/05/11 21:28
 */
@SuppressWarnings("all")
public class RedBlackTree {

    private static final int B = 1;
    private static final int R = 0;

    /**
     * 定义一个节点
     */
    public class Node{
        int data;
        int clolr = R;
        Node left =null;
        Node right = null;
        Node parent = null;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 左旋
     * @param node
     */
    void leftRotate(Node node){
        if (node.parent != null) {
            // 不是根节点
            // 获取此节点的右节点
            Node right = node.right;
            if (node.parent.left != null && node.parent.left == node) {
                // 此节点的父节点的左节点等于此节点，那么把其变成右节点
                node.parent.left = right;
            } else if (node.parent.right != null && node.parent.right == node) {
                // 此节点的父节点的右节点等于此节点，那么把其变成右节点
                node.parent.right = right;
            }
            // 右节点的父节点变成此节点的父节点
            right.parent = node.parent;
            // 此节点的父节点变成右节点
            node.parent = right;
            // 此节点的右节点变成了原来右节点的左节点
            node.right = right.left;
            // 右节点原来的左节点的父节点变成此节点
            right.left.parent = node;
            // 右节点的左节点变成此节点
            right.left = node;
        } else {
            // 是跟节点
            Node right = node.right;
            // 根节点的父节点变成右节点
            node.parent = right;
            // 根节点的右节点变成了原来右节点的左节点
            node.right = right.left;
            // 右节点的父节点变成空
            right.parent = null;
            // 右节点原来的左节点的父节点变成跟节点
            right.left.parent = node;
            // 右节点的左节点变成根节点
            right.left = node;

        }
    }

    /**
     * 右旋
     * @param node
     */
    void rightRotate(Node node) {
        if (node.parent != null) {
            // 不是根节点
            Node left = node.left;
            // 根节点的父节点，变成了跟节点的左节点
            node.parent = left;
            // 左节点的父节点，变成了根节点的父节点
            left.parent = node.parent;
            if (node.parent.left != null && node.parent.left == node) {
                // 根节点的父节点的左节点，变成了左节点
                node.parent.left = left;
            } else if (node.parent.right != null && node.parent.right == node) {
                // 根节点的父节点的右节点，变成了左节点
                node.parent.left = left;
            }
            // 把左节点的右节点的父节点，变成根节点
            left.right.parent = node;
            // 把根节点的左节点，变成左节点的右节点
            node.left = left.right;
            // 把左节点的右节点，变成跟节点
            left.right = node;
        } else {
            // 是根节点
            Node left = node.left;
            // 根节点的父节点，变成了跟节点的左节点
            node.parent = left;
            // 左节点的父节点，变成空
            left.parent = null;
            // 把左节点的右节点的父节点，变成根节点
            left.right.parent = node;
            // 把根节点的左节点，变成左节点的右节点
            node.left = left.right;
            // 把左节点的右节点，变成跟节点
            left.right = node;

        }
    }
}