package com.coderlucifar.leetcode.week06.binarytree.type2;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  从上到下打印二叉树(中等)
 */
public class SwordToOffer32I {
    class Solution {

        public int[] levelOrder(TreeNode root) {
            if (root == null) return new int[]{};
            List<Integer> result = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                result.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            int[] res = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }
            return res;
        }

    }
}
