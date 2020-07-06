import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (38.76%)
 * Likes:    5023
 * Dislikes: 217
 * Total Accepted:    1M
 * Total Submissions: 2.6M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        char[] parentheses = s.toCharArray();
        Deque<Character> pStack = new ArrayDeque<>();

        for (int i = 0; i < parentheses.length; i++) {
            if ('(' == parentheses[i] || '[' == parentheses[i] || '{' == parentheses[i]) {
                pStack.push(parentheses[i]);
            } else if (')' == parentheses[i] || ']' == parentheses[i] || '}' == parentheses[i]) {
                if (!pStack.isEmpty()) {
                    char top = pStack.pop();
                    switch (parentheses[i]) {
                        case ')':
                            if ('(' != top) {
                                return false;
                            }
                            break;
                        case ']':
                            if ('[' != top) {
                                return false;
                            }
                            break;
                        case '}':
                            if ('{' != top) {
                                return false;
                            }
                            break;
                    }
                } else {
                    return false;
                }
            }
        }
        if (!pStack.isEmpty()) {
            return false;
        }
        return true;
    }
}
// @lc code=end
