package com.coderlucifar.leetcode.week06.binarytree.type1;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的前序遍历（简单）
 *
 */
public class Leetcode589 {
    class Node {
        public int val;
        public List<Node> children;
        public Node() {};
        public Node(int _val) {
            this.val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return result;
        result.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return result;
    }

}
