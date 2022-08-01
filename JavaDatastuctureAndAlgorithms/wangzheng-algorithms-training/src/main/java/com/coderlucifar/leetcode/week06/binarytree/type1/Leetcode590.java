package com.coderlucifar.leetcode.week06.binarytree.type1;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的后序遍历（简单）
 *
 */
public class Leetcode590 {
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

    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) return result;
        for (Node child : root.children) {
            postorder(child);
        }
        result.add(root.val);
        return result;
    }

}
