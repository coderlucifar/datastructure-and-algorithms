package com.coderlucifar.leetcode.week06.binarytree.type4;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的第k大节点(简单)
 *
 * 解题思路：利用二叉搜索树中序遍历结果是有序的特点。
 */
public class SwordToOffer54 {
    class Solution {
        List<Integer> result = new ArrayList<>();
        public int kthLargest(TreeNode root, int k) {
            inorderTraversal(root);
            int size = result.size();
            if (size < k) return -1;
            return result.get(k-1);
        }
        private void inorderTraversal(TreeNode root) {
            if (root == null) return;
            if (root.right != null) {
                inorderTraversal(root.right);
            }
            result.add(root.val);
            if (root.left != null) {
                inorderTraversal(root.left);
            }
            return;
        }
    }
}
