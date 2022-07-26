package leetcode.queue;

import java.util.LinkedList;

/**
 * 给定一个长度为 n 的环形整数数组nums，返回nums的非空 子数组 的最大可能和。
 *
 * 环形数组意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i]的前一个元素是 nums[(i - 1 + n) % n] 。
 *
 * 子数组 最多只能包含固定缓冲区nums中的每个元素一次。形式上，对于子数组nums[i], nums[i + 1], ..., nums[j]，不存在i <= k1, k2 <= j其中k1 % n == k2 % n。
 */
public class maxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int maxVal = nums[0],minVal = nums[0],preMin = 0,preMax = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            preMax = Math.max(preMax + nums[i], nums[i]);
            maxVal = Math.max(maxVal, preMax);
            preMin = Math.min(preMin+nums[i],nums[i]);
            minVal = Math.min(minVal,preMin);
            sum += nums[i];
        }
        return Math.max(maxVal,sum-minVal==0?maxVal:sum-minVal);
    }

}
