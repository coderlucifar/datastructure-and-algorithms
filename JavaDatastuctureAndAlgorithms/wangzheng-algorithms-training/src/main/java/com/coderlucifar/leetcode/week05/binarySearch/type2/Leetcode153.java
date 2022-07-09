package com.coderlucifar.leetcode.week05.binarySearch.type2;

/**
 * leetcode153：寻找旋转排序数组中的最小值：
 *
 */
public class Leetcode153 {
    class Solution {
        public int findMin(int[] nums) {
            int n = nums.length-1;
            //处理特殊情况和边界情况
            if(nums.length == 1) {
                return nums[0];
            } else if((nums[0] < nums[1]) && (nums[0] < nums[n])) {
                return nums[0];
            } else if(nums[n] < nums[n-1] && nums[n] < nums[0]) {
                return nums[n];
            }
            //将特殊情况和边界情况处理后，将low和high的值分别加一，减一，这样就可以避免在后续代码中的
            //数组下标越界问题
            int low = 1;
            int high = nums.length-2;
            while(low <= high) {
                int mid = low + (high-low)/2;
                if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) {
                    return nums[mid];
                } else if(nums[low] < nums[mid]) {
                    //说明[low,mid]一定是单调增区间
//                    low = mid + 1;    //这么写可能会将正确答案的所在区间直接跳过
                    low = mid;
                } else if(nums[low] > nums[mid]) {
                    //说明[mid,high]一定是单调增区间
//                    high = mid - 1;   //这么写可能会将正确答案所在区间直接跳过
                    high = mid;
                } else {
                    //此时 nums[low] == nums[mid]
                    //由于不存在重复元素，说明low和mid此时相等了
                    //说明此时low和high重合了，或者low就在high的前一个
                    if(low == high) {
                        //low和high重合还没找到，就找不到了。
                        break;
                    } else {
                        low++;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Leetcode153 leetcode153 = new Leetcode153();
        Solution solution = leetcode153.new Solution();
        int[] nums = new int[]{3,4,5,1,2};
        int min = solution.findMin(nums);
        System.out.println(min);
    }
}
