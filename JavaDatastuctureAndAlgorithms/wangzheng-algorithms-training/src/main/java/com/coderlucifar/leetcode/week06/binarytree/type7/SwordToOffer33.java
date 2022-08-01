package com.coderlucifar.leetcode.week06.binarytree.type7;

/**
 * 剑指Offer33. 二叉搜索树的后序遍历序列(中等)
 *      输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 *      如果是则返回 true，否则返回 false。
 *      假设输入的数组的任意两个数字都互不相同。
 */
public class SwordToOffer33 {

    class Solution {

        private boolean verify = true;

        /**
         *  判断数组中的元素是不是平衡二叉树的后序遍历结果！
         */
        public boolean verifyPostorder(int[] postorder) {
            verifyPostorderImpl(postorder, 0, postorder.length-1);
            return this.verify;
        }

        private void verifyPostorderImpl(int[] postorder, int i, int j) {
            // 递归出口
            if (i >= j) return ;
            // 让p指针指向左边界
            int p = i;
            // 在[i, j-1]寻找第一个值比根节点值大的节点的位置
            while (p < j && postorder[p] < postorder[j]) {
                p++;
            }
            // 如果找到了, 验证一下后面的节点值是否都比根结点值大，如果不是，说明不满足题意
            if (p < j) {
                for (int i1 = p; i1 < j; i1++) {
                    if (postorder[i1] > postorder[j]) continue;
                    else {
                        this.verify = false;
                        return ;
                    }
                }
            }

            // 判断左子树是不是后序遍历结果
            verifyPostorderImpl(postorder, i, p-1);
            if (this.verify == false) return;   // 剪枝
            // 判断右子树是不是后序遍历结果
            verifyPostorderImpl(postorder, p, j-1); // 剪枝
            if (this.verify == false) return;
            return ;
        }

    }

}
