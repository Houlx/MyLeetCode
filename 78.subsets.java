import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (60.41%)
 * Likes:    3869
 * Dislikes: 84
 * Total Accepted:    591.2K
 * Total Submissions: 960.7K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int len, subSize;

    public List<List<Integer>> subsets(int[] nums) {
        len = nums.length;
        for (subSize = 0; subSize <= len; subSize++) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }

        return res;
    }

    private void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        if (curr.size() == subSize)
            res.add(new ArrayList(curr));

        for (int i = first; i < len; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
// @lc code=end
