import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (30.22%)
 * Likes:    9406
 * Dislikes: 568
 * Total Accepted:    1.6M
 * Total Submissions: 5.2M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == "" || s == null || s.length() == 0) {
            return 0;
        }
        // Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        int i = 0, j = 0;
        int res = 1;
        while (i < chs.length && j < chs.length) {
            if (!map.containsKey(chs[j])) {
                map.put(chs[j], j);
                res = Math.max(j - i + 1, res);
                j++;
            } else {
                int nexti = map.get(chs[j]) + 1;
                while (i < nexti && !map.isEmpty()) {
                    map.remove(chs[i]);
                    i++;
                }
                map.put(chs[j], j);
                j++;
            }
        }
        return res;
    }
}
// @lc code=end
