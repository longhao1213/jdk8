package com.jdk.tree;


import java.util.Random;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: BinarySearchTree.java
 * 二分查找数实现
 * @author lh
 * @version 1.0.0
 * @Date 2020/05/11 09:34
 */
public class BinarySearchTree {
    private int data;
    private BinarySearchTree left;
    private BinarySearchTree right;

    public BinarySearchTree(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    /**
     * 插入方法
     * @param root 根节点
     * @param data 插入的数
     */
    public void insert(BinarySearchTree root, int data) {
        if (root.data < data) {
            // 比根节点大，那数据放在右边
            if (root.right == null) {
                // 根节点右边没有值，直接插入
                root.right = new BinarySearchTree(data);
            } else {
                // 右边有值，递归的查找到最右边
                insert(root.right, data);
            }
        } else if (root.data > data) {
            // 比根节点小，那数据放在左边
            if (root.left == null) {
                root.left = new BinarySearchTree(data);
            } else {
                insert(root.left, data);
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void in(BinarySearchTree root) {
        if (root != null) {
            in(root.left);
            System.out.println(root.data);
            in(root.right);
        }
    }

    public static void main(String[] args){
        BinarySearchTree binarySearchTree = new BinarySearchTree(5);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            binarySearchTree.insert(binarySearchTree, random.nextInt(10));
        }
        binarySearchTree.in(binarySearchTree);
    }
}