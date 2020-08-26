import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (46.61%)
 * Likes:    1778
 * Dislikes: 79
 * Total Accepted:    289.5K
 * Total Submissions: 612.8K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int curSize;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for (curSize = 0; curSize <= nums.length; curSize++) {
            backtrack(new ArrayList<Integer>(), 0, nums);
        }
        return new ArrayList<>(new HashSet<>(list));
    }

    private void backtrack(ArrayList<Integer> cur, int first, int[] nums) {
        if (cur.size() == curSize) {
            list.add(new ArrayList<>(cur));
        }

        for (int i = first; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(cur, i + 1, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end
