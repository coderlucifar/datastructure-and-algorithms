package com.coderlucifar.leetcode.week06.binarytree.type3;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

/**
 * 合并二叉树(简单)
 *      分解为子问题，然后再用子问题的解求解原问题
 */
public class Leetcode617 {
    class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) return root2;
            if (root2 == null) return root1;
            // 合并两颗树的左子树
            TreeNode leftChild = mergeTrees(root1.left, root2.left);
            // 合并两颗树的右子树
            TreeNode rightChild = mergeTrees(root1.right, root2.right);
            TreeNode root = new TreeNode(root1.val + root2.val);
            root.left = leftChild;
            root.right = rightChild;
            return root;
        }
    }
}
