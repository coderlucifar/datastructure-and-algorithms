package com.coderlucifar.leetcode.week06.binarytree.type1;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  二叉树的前序遍历（简单）
 */
public class Leetcode144 {
    class Solution {
        private List<Integer> result = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) return result;
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return result;
        }
    }
}
