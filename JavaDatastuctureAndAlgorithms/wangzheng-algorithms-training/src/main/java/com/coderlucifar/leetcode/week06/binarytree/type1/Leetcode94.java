package com.coderlucifar.leetcode.week06.binarytree.type1;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 *  提示：
 *      树中节点数目在范围 [0, 100] 内
 *      -100 <= Node.val <= 100
 *
 *  进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Leetcode94 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        private List<Integer> result = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return result;
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
            return result;
        }
    }
}
