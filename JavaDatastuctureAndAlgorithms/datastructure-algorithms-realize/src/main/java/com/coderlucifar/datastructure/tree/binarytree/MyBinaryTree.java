package com.coderlucifar.datastructure.tree.binarytree;

import java.util.Stack;

/**
 *  我的二叉树
 */
public class MyBinaryTree {

    /**
     * 定义树节点
     */
    private class TreeNode {
        // 节点值
        public Object value;
        // 左指针
        public TreeNode left = null;
        // 右指针
        public TreeNode right = null;
        // 构造器初始化
        public TreeNode(Object value) {
            this.value = value;
        }
    }

    /**
     * 定义栈帧
     *  实现遍历的非递归写法需要用到
     *  1、status等于1时，
     *  2、status等于2时，
     *  3、status等于3时，
     */
    private class StackFrame {
        public int status = 1;
        public TreeNode node = null;
        public StackFrame(int status, TreeNode node) {
            this.status = status;
            this.node = node;
        }
    }

    /**
     * 前序遍历的递归写法
     */
    public void preOrderTraversalByRecursion(TreeNode node) {
        if (node == null) return;
        System.out.println(node.value);
        preOrderTraversalByRecursion(node.left);
        preOrderTraversalByRecursion(node.right);
    }


    /**
     * 前序遍历的非递归写法
     */
    public void preOrderTraversal(TreeNode node) {
        if (node == null) return;
        // 调用栈
        Stack<StackFrame> frameStack = new Stack<>();
        // 根节点封装成栈帧，入栈。
        frameStack.push(new StackFrame(1, node));
        while (!frameStack.isEmpty()) {
            if (frameStack.peek().status == 1) {
                // 前序遍历
                System.out.println(frameStack.peek().node.value);
                frameStack.peek().status = 2;
                if (frameStack.peek().node.left != null) {
                    frameStack.push(new StackFrame(1, frameStack.peek().node.left));
                }
                continue;
            }
            if (frameStack.peek().status == 2) {
                frameStack.peek().status = 3;
                if (frameStack.peek().node.right != null) {
                    frameStack.push(new StackFrame(1, frameStack.peek().node.right));
                }
                continue;
            }
            if (frameStack.peek().status == 3) {
                frameStack.pop();
            }
        }


    }






}
