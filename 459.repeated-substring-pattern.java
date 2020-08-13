/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 *
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 *
 * algorithms
 * Easy (42.18%)
 * Likes:    1607
 * Dislikes: 155
 * Total Accepted:    129.7K
 * Total Submissions: 307.6K
 * Testcase Example:  '"abab"'
 *
 * Given a non-empty string check if it can be constructed by taking a
 * substring of it and appending multiple copies of the substring together. You
 * may assume the given string consists of lowercase English letters only and
 * its length will not exceed 10000.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "aba"
 * Output: False
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring
 * "abcabc" twice.)
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int pos = len / 2;
        while (pos >= 1) {
            int repeat = len / pos;
            String sub = s.substring(0, pos);
            if (sub.repeat(repeat).equals(s))
                return true;
            pos--;
        }
        return false;
    }
}
// @lc code=end
