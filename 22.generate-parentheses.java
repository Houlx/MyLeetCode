import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (62.01%)
 * Likes:    5638
 * Dislikes: 282
 * Total Accepted:    582K
 * Total Submissions: 925.1K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, String item, int open, int close, int n) {
        if (item.length() == 2 * n) {
            res.add(item);
            return;
        }

        if (open < n) {
            backtrack(res, item + "(", open + 1, close, n);
        }
        if (open > close) {
            backtrack(res, item + ")", open, close + 1, n);
        }
    }
}
// @lc code=end
