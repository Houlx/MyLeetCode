/*
 * @lc app=leetcode id=537 lang=java
 *
 * [537] Complex Number Multiplication
 *
 * https://leetcode.com/problems/complex-number-multiplication/description/
 *
 * algorithms
 * Medium (67.18%)
 * Likes:    240
 * Dislikes: 724
 * Total Accepted:    47.1K
 * Total Submissions: 70.1K
 * Testcase Example:  '"1+1i"\n"1+1i"'
 *
 * 
 * Given two strings representing two complex numbers.
 * 
 * 
 * You need to return a string representing their multiplication. Note i^2 = -1
 * according to the definition.
 * 
 * 
 * Example 1:
 * 
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i^2 + 2 * i = 2i, and you need convert
 * it to the form of 0+2i.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i^2 - 2 * i = -2i, and you need convert
 * it to the form of 0+-2i.
 * 
 * 
 * 
 * Note:
 * 
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and
 * b will both belong to the range of [-100, 100]. And the output should be
 * also in this form.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] complex1 = getComplex(a);
        int[] complex2 = getComplex(b);

        return complex1[0] * complex2[0] - complex1[1] * complex2[1] + "+"
                + (complex1[0] * complex2[1] + complex1[1] * complex2[0]) + "i";
    }

    public int[] getComplex(String a) {
        int x, y;
        int i = 0;
        while (a.charAt(i) != '+') {
            i++;
        }
        x = Integer.parseInt(a.substring(0, i));
        int tmp = i + 1;
        while (a.charAt(i) != 'i') {
            i++;
        }
        y = Integer.parseInt(a.substring(tmp, i));
        return new int[] { x, y };
    }
}
// @lc code=end
