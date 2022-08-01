package com.coderlucifar.leetcode.week06.binarytree.type2;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  二叉树的层序遍历 (中等)
 *     借助队列求解！
 *      解法一、记录层号
 *      解法二、用null做分隔
 *      解法三、记录每行的size
 *
 *      提示：
 *          树中节点数目在范围 [0, 2000] 内
 *          -1000 <= Node.val <= 1000
 */
public class Leetcode102 {
    class Solution {
        // 用来封装层号和节点
        private class QNode {
            public int level;
            public TreeNode node;
            public QNode(int level, TreeNode node) {
                this.level = level;
                this.node = node;
            }
        }

        /**
         * 通过记录层号并使用队列，非递归实现层序遍历
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            //
            List<List<Integer>> result = new ArrayList<>();
            //
            if (root == null) return result;
            // 创建队列
            Queue<QNode> queue = new LinkedList<>();
            // 将根节点入队，根节点在第0层
            queue.add(new QNode(0, root));
            // 队列非空就一直循环
            while (!queue.isEmpty()) {
                // 当前节点出队列
                QNode qNode = queue.poll();
                // 扩充结果数组的条件
                if (qNode.level > result.size() - 1) {
                    result.add(new ArrayList<Integer>());
                }
                // 将当前节点的值加入它应该加入的层数
                result.get(qNode.level).add(qNode.node.val);
                //
                if (qNode.node.left != null) {
                    queue.add(new QNode(qNode.level+1, qNode.node.left));
                }
                if (qNode.node.right != null) {
                    queue.add(new QNode(qNode.level+1, qNode.node.right));
                }
            }
            return result;
        }

    }
}
