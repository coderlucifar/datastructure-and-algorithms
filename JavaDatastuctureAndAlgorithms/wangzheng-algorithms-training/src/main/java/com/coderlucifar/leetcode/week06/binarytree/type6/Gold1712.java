package com.coderlucifar.leetcode.week06.binarytree.type6;

/**
 * BiNode（简单）   20220727
 *      二叉树数据结构TreeNode可用来表示单向链表
 *      （其中left置空，right为下一个链表节点）。
 *      实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，
 *      转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *      返回转换后的单向链表的头节点。
 */
public class Gold1712 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        private TreeNode newHead = new TreeNode(-1);
        private TreeNode tail = newHead;

        public TreeNode convertBiNode(TreeNode root) {
            if (root == null) return null;

            // 草，之前下面两行忘了取消，导致返回的不是 this.newHead 而是 局部变量newHead。
            // 警示，如果要对类中的属性进行操作，一定要加 this. , 以免与局部变量冲突！！！
//            TreeNode newHead = new TreeNode(-1);
//            TreeNode tail = newHead;


            inorderTraversal(root);
            return this.newHead.right;
        }

        private void inorderTraversal(TreeNode root) {
            if (root.left != null) {
                inorderTraversal(root.left);
            }

            TreeNode right = root.right;
            // 将当前节点接到链表尾部
            this.tail.right = root;
            // 将尾指针重新移动到当前链表尾部
            this.tail = root;
            // 将链表尾部的节点 左右指针都置为空
            // 注意，这里必须每插入一个节点，尾节点的left指针就立马置空，否则可能会成环
            // 那么哪种例子下，如果在这个位置不把 left置为空会有环？
            this.tail.right = null;
            this.tail.left = null;   // 这一句必须要补，否则最后的结果可能会有环

            if (right != null) {
                inorderTraversal(right);
            }
            return;
        }

    }

    public static void main(String[] args) {
        Gold1712 gold1712 = new Gold1712();
        Solution solution = gold1712.new Solution();

        TreeNode root = new Gold1712().new TreeNode(4);
        TreeNode node1 = new Gold1712().new TreeNode(2);
        TreeNode node2 = new Gold1712().new TreeNode(5);
        TreeNode node3 = new Gold1712().new TreeNode(1);
        TreeNode node4 = new Gold1712().new TreeNode(3);
        TreeNode node5 = new Gold1712().new TreeNode(6);
        TreeNode node6 = new Gold1712().new TreeNode(0);
        root.left = node1;
        root.right = node2;
        node2.right = node5;
        node1.left = node3;
        node1.right = node4;
        node3.left = node6;


        solution.convertBiNode(root);
    }

}
