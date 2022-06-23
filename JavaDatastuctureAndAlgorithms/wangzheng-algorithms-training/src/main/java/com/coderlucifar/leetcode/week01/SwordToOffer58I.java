package com.coderlucifar.leetcode.week01;

/**
 * 这道题第一次做20220518，大概做了4个小时，而且还是在看了小争哥题解思路的情况下。
 * 很多边界细节处理考虑不全。
 *
 * 剑指Offer 58 - I. 翻转单词顺序：
 *  输入一个英文句子翻转句子中单词的顺序，但单词内字符的顺序不变。
 *  为简单起见，标点符号和普通字母一样处理。
 *  例如输入字符串"I am a student." 则输出"student. a am I"
 *
 *  注意：
 *      无空格字符构成一个单词；
 *      输入的字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括；
 *      如果两个单词间有多余的空格，将反转后单词间的空格减少到只含有一个。
 */
public class SwordToOffer58I {

    class Solution {



        public String reverseWords(String s) {
            if (s == null) {
                return null;
            }
            char[] chars = s.toCharArray();
            //直接在原数组上去除多余的空格
            int actuallyLength = trim(chars);
//            System.out.println(chars);
            //反转操作
            //先将全部字符翻转
            reverse(0, actuallyLength-1, chars);
//            System.out.println(chars);
            //然后在把单词内部翻转
            int k = 0;
            while (k < actuallyLength) {
                //当前单词的开始下标
                int head = k;
                //循环找到当前单词尾部下标
                while (chars[k] != ' ' && k < actuallyLength){
                    k++;
                    //之前少了这个if判断造成了数组下标越界异常
                    if (k == actuallyLength) {
                        break;
                    }
                }
                reverse(head, k-1, chars);
                k = k + 1;
            }

            //注意这里构造字符串需要指明字符的其实下标和结束下标。否则会将尾部多余的空字符也转为字符串
            return new String(chars, 0, actuallyLength);
        }

        /**
         * 去除字符数组中多余的空格
         * 注意：需要返回数组中实际有效字符的长度，因为这个长度，后面要用。
         * @param chars
         */
        private int trim(char[] chars) {
            //获取字符数组原长度
            int length = chars.length;
            //跳过首空格（这种处理方式参考了答案）
            int i = 0;
            while (i < length && chars[i] == ' ') {
                i++;
            }
            //跳过尾空格
            int j = length - 1;
            while (j >= 0 && chars[j] == ' ') {
                j--;
            }

            //去除单词间多余的空格，并把单词按顺序搬运到数组最前面
            int slot = 0;   //当前数组下标可插入的槽位
            int emptyCharNum = 0; //用于暂时存储单词间空字符数量
            while (i <= j) {
                //如果当前字符不等于空
                if (chars[i] != ' ') {
                    //将该字符搬运到数组最前面的空余位置
                    chars[slot] = chars[i];
                    //注意：下面这行代码漏了就会有bug，第一次实现的时候就漏了，当把这个位置的值搬走之后，需要将这个位置置为空字符，否则会影响后续的判断逻辑
                    if (i != slot) {
                        chars[i] = ' ';
                    }
                    //slot更新为下一个可插入的下标
                    slot++;
                    //当前处理到的元素下标更新
                    i++;
                    //只要当前字符不等于空，emptyCharNum的值就需要重置为0
                    emptyCharNum = 0;
                }
                //如果当前字符等于空了
                else {
                    if (emptyCharNum == 0) {
                        //给最新的槽位先插入一个空字符
                        chars[slot] = ' ';
                        //移动到下一个可插入槽位
                        slot++;
                        //当前处理到的字符下标前移
                        i++;
                        emptyCharNum++;
                    } else {
                        //跳过单词间第一个空字符后的其余空字符
                        //当前处理位置前移
                        i++;
                    }
                }
            }

            return slot;
        }

        /**
         * 给一个字符数组，然后给起使下标和结束下标。
         * 将中间的字符全部反转
         */
        private void reverse(int left, int right, char[] chars) {
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }




    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        SwordToOffer58I swordToOffer58I = new SwordToOffer58I();
        Solution solution = swordToOffer58I.new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
        System.out.println(solution.reverseWords("  hello world!  "));
        System.out.println(solution.reverseWords("a good    example"));

    }
}
