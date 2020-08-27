/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (46.31%)
 * Likes:    7945
 * Dislikes: 373
 * Total Accepted:    1M
 * Total Submissions: 2.2M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] maxSub = new int[nums.length];
        maxSub[0] = nums[0];
        int max = maxSub[0];
        for (int i = 1; i < maxSub.length; i++) {
            maxSub[i] = maxSub[i - 1] < 0 ? nums[i] : (nums[i] + maxSub[i - 1]);
            max = maxSub[i] > max ? maxSub[i] : max;
        }
        return max;
    }
}
// @lc code=end
