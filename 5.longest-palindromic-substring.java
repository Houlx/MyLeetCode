/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (29.31%)
 * Likes:    6895
 * Dislikes: 536
 * Total Accepted:    942K
 * Total Submissions: 3.2M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.equals(""))
            return "";
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = expand(s, i, i);
            String s2 = expand(s, i, i + 1);
            String sr = s1.length() > s2.length() ? s1 : s2;
            if (sr.length() > res.length())
                res = sr;
        }
        return res;
    }

    private String expand(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return s.substring(L + 1, R);
    }
}
// @lc code=end
