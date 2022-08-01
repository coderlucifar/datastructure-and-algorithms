package com.coderlucifar.leetcode.week06.binarytree.type2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历（中等）
 */
public class Leetcode429 {

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

    private class QNode {
        public int level;
        public Node node;
        public QNode(int _level, Node _node) {
            this.level = _level;
            this.node = _node;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            Queue<QNode> queue = new LinkedList<>();
            queue.add(new QNode(0, root));
            while (!queue.isEmpty()) {
                QNode q = queue.poll();
                if (q.level > result.size() - 1) {
                    result.add(new ArrayList<Integer>());
                }
                result.get(q.level).add(q.node.val);
                if (q.node.children != null) {
                    for (Node child : q.node.children) {
                        queue.add(new QNode(q.level+1, child));
                    }
                }
            }
            return result;
        }
    }
}
