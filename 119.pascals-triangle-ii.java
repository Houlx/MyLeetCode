import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (48.54%)
 * Likes:    820
 * Dislikes: 197
 * Total Accepted:    284.1K
 * Total Submissions: 583.3K
 * Testcase Example:  '3'
 *
 * Given a non-negative index k where k ≤ 33, return the k^th index row of the
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: [1,3,3,1]
 * 
 * 
 * Follow up:
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0)
            return new ArrayList<Integer>() {
                {
                    add(1);
                }
            };
        else if (rowIndex == 1)
            return new ArrayList<Integer>() {
                {
                    add(1);
                    add(1);
                }
            };
        else {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            List<Integer> pre = getRow(rowIndex - 1);
            for (int i = 1; i < rowIndex; i++) {
                res.add(pre.get(i - 1) + pre.get(i));
            }
            res.add(1);
            return res;
        }
    }
}
// @lc code=end
