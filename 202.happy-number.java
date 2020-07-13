import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 *
 * https://leetcode.com/problems/happy-number/description/
 *
 * algorithms
 * Easy (50.21%)
 * Likes:    2153
 * Dislikes: 427
 * Total Accepted:    513.2K
 * Total Submissions: 1M
 * Testcase Example:  '19'
 *
 * Write an algorithm to determine if a number n is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Return True if n is a happy number, and False if not.
 * 
 * Example: 
 * 
 * 
 * Input: 19
 * Output: true
 * Explanation: 
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        if (n == 0)
            return false;
        if (n == 1)
            return true;

        Map<Integer, Integer> map = new HashMap<>();

        int sum = powSum(n);
        while (true) {
            if (sum == 1) {
                return true;
            } else {
                if (map.containsKey(sum)) {
                    return false;
                } else {
                    map.put(sum, sum);
                    sum = powSum(sum);
                }
            }
        }
    }

    public int powSum(int n) {
        int result = 0;
        while (n > 0) {
            int digit = n % 10;
            result += digit * digit;
            n /= 10;
        }
        System.out.println("powSum(" + n + ")=" + result);
        return result;
    }
}
// @lc code=end
