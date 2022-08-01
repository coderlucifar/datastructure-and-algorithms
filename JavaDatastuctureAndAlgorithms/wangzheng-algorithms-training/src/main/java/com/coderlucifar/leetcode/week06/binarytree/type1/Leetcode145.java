package com.coderlucifar.leetcode.week06.binarytree.type1;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历（简单）
 *
 */
public class Leetcode145 {
    class Solution {
        private List<Integer> result = new ArrayList<>();
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) return result;
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            result.add(root.val);
            return result;
        }
    }
}
