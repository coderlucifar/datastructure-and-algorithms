package com.coderlucifar.leetcode.week01;

/**
 * 程序员面试金典：面试题16.15.珠玑妙算(中等)
 *      解：先把真猜中的位置找出来，然后把真猜中的位置去掉，对比剩余位置的元素有几组相同的，可以先排序再按顺序对比。
 */
public class Gold1615 {
    class Solution {
        public int[] masterMind(String solution, String guess) {

            char[] solutionChars = solution.toCharArray();
            char[] guessChars = guess.toCharArray();
            int tureGuess = 0;
            int fakeGuess = 0;
            boolean[] hits = new boolean[4];

            for (int i = 0,j = 0; i < 4 && j < 4; i++, j++) {
                    if (guessChars[i] == solutionChars[j]) {
                        //真猜中的
                        tureGuess++;
                        hits[i] = true;
                    }
            }

            char[] newSolutionChar = new char[4-tureGuess];
            char[] newGuessChar = new char[4-tureGuess];
            int k = 0;
            int p = 0;
            while (k < 4) {
                if (hits[k]) {
                    k++;
                } else {
                    newSolutionChar[p] = solutionChars[k];
                    newGuessChar[p] = guessChars[k];
                    k++;
                    p++;
                }
            }

            boolean[] used = new boolean[p];
            for (int i = p-1; i >= 0; i--) {
                for (int j = 0; j < p; j++) {
                    if ((newGuessChar[j] == newSolutionChar[i]) && !used[j]) {
                        fakeGuess++;
                        used[j] = true;
                        break;
                    }
                }
            }
            return new int[]{tureGuess,fakeGuess};
        }
    }

    public static void main(String[] args) {
        Gold1615 gold1615 = new Gold1615();
        Solution solution = gold1615.new Solution();
        String solution1 = "RRBY";
        String guess1 = "RRGB";
        int[] ints = solution.masterMind(solution1, guess1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
