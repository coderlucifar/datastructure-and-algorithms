package com.coderlucifar.leetcode.week01;

/**
 * 程序员面试金典：面试题目01.05.一次编辑(中等)
 *      字符串有三种编辑操作：插入一个字符、删除一个字符或者替换一个字符。
 *      给定两个字符串，编写一个函数，判定他们是否只需要一次(或者零次)编辑。
 */
public class Gold0105 {
    class Solution {
        public boolean oneEditAway(String first, String second) {
            char[] firstChars = first.toCharArray();
            char[] secondChars = second.toCharArray();
            int fLength = firstChars.length;
            int sLength = secondChars.length;
            //用于统计不一样的字符个数
            int i = 0;
            //如果字符数组长度相差2个以上，那么就无法通过一次编辑搞定。
            if (Math.abs(fLength-sLength) > 1) return false;
            else if (fLength == sLength) {
                for (int j = 0; j < fLength; j++) {
                    if (firstChars[j] != secondChars[j]) i++;
                    if (i > 1) return false;
                }
            }
            else {
                for (int j = 0,k = 0; (j < sLength) && (k < fLength); j++, k++) {
                    //遇到不一样的字符时
                    if (firstChars[k] != secondChars[j]) {
                        //用来记录不一样的字符数量
                        i++;
                        //如果不一样的字符超过两个，不满足条件
                        if (i > 1) return false;
                        //较长的数组指针前移
                        if (sLength > fLength) {
                            j++;
                        } else {
                            k++;
                        }
                        if (secondChars[j] != firstChars[k]) return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Gold0105 gold0105 = new Gold0105();
        Solution solution = gold0105.new Solution();
        String first =  "teacher";
        String second = "bleacher";
        boolean b = solution.oneEditAway(first, second);
        System.out.println(b);
    }
}
