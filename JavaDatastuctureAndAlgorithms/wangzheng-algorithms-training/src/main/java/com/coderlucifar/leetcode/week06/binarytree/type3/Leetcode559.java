package com.coderlucifar.leetcode.week06.binarytree.type3;


import java.util.List;

/**
 * N叉树的最大深度（简单）
 */
public class Leetcode559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    class Solution {
        public int maxDepth(Node root) {
            if (root == null) return 0;
            int max = 0;
            if (root.children != null) {
                for (int i = 0; i < root.children.size(); i++) {
                    int i1 = maxDepth(root.children.get(i));
                    if (i1 > max) max = i1;
                }
            }
            return max + 1;
        }
    }
}
