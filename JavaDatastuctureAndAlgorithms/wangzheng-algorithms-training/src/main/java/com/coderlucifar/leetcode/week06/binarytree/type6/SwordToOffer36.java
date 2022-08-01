package com.coderlucifar.leetcode.week06.binarytree.type6;

import java.util.HashMap;

/**
 *      剑指offer36题：二叉搜索树与双向链表（中等）   20220727
 *          输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 *
 *          要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 *       分析：这道题要求不能创建任何节点，所以不能利用之前学过的创建虚拟头节点的方法。
 *       所以这道题的关键就是如何定位头节点然后我们就可以利用之前的解法来求解。
 *       这道题重点理解递归找到头节点的过程。
 */
public class SwordToOffer36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };


    class Solution {

        private Node head = null;
        private Node tail = null;

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            inorderTraversal(root);
            this.head.left = this.tail;
            this.tail.right = this.head;
            return this.head;
        }

        /**
         * 在不能利用虚拟头节点的情况下是如何找到头节点的？？？
         *      因为在中序遍历过程中，首先会一直向左递归，直到找到最左边的节点为止，
         *      所以在第一次执行左递归后面的代码逻辑时，当前的root节点就是头节点。
         *
         */
        private void inorderTraversal(Node root) {
            if (root.left != null) {
                inorderTraversal(root.left);
            }

            if (tail != null) {
                tail.right = root;  // 1
            } else {
                // 在向左递归的过程中，第一次出左递归逻辑时，就找到了头节点
                // 但是找到头节点之后如何保证在处理下个节点的过程中 head不会再改变，关键在于找到最终的头节点后，对tail的处理
                // 这句代码只会执行一次，当找到了头节点后，尾节点就会更新为头节点，然后尾节点就再也不为null了，就保证了头节点在后面的处理过程中都不会被更改。
                head = root;
            }
            root.left = tail;   // 2
            tail = root;    // 3

            if (root.right != null) {
                inorderTraversal(root.right);
            }
        }

    }
}
