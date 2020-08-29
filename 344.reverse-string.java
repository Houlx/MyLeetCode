/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 *
 * https://leetcode.com/problems/reverse-string/description/
 *
 * algorithms
 * Easy (68.10%)
 * Likes:    1577
 * Dislikes: 709
 * Total Accepted:    806.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '["h","e","l","l","o"]'
 *
 * Write a function that reverses a string. The input string is given as an
 * array of characters char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of printable ascii
 * characters.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        if (s.length == 0)
            return;
        for (int j = s.length - 1; j >= s.length / 2; j--) {
            char tmp = s[j];
            s[j] = s[s.length - 1 - j];
            s[s.length - 1 - j] = tmp;
        }
    }
}
// @lc code=end
