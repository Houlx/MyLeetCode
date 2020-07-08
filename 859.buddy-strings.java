import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=859 lang=java
 *
 * [859] Buddy Strings
 *
 * https://leetcode.com/problems/buddy-strings/description/
 *
 * algorithms
 * Easy (27.52%)
 * Likes:    534
 * Dislikes: 373
 * Total Accepted:    45.8K
 * Total Submissions: 166.4K
 * Testcase Example:  '"ab"\n"ba"'
 *
 * Given two strings A and B of lowercase letters, return true if and only if
 * we can swap two letters in A so that the result equals B.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: A = "ab", B = "ba"
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = "ab", B = "ab"
 * Output: false
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = "aa", B = "aa"
 * Output: true
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: A = "", B = "aa"
 * Output: false
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() < 2 || B.length() < 2 || A.length() != B.length())
            return false;
        if (A.equals(B)) {
            for (int i = 0; i < A.length(); i++) {
                for (int j = i + 1; j < A.length(); j++) {
                    if (A.charAt(i) == A.charAt(j)) {
                        return true;
                    }
                }
            }
        }

        Deque<Character> deque = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < A.length(); i++) {
            char Ai = A.charAt(i);
            char Bi = B.charAt(i);
            if (Ai != Bi && cnt % 2 == 0) {
                cnt++;
                deque.add(Bi);
                deque.add(Ai);
            } else if (Ai != Bi && cnt % 2 == 1) {
                cnt++;
                char qB = deque.remove();
                char qA = deque.remove();
                if (qB != Ai || qA != Bi) {
                    return false;
                }
            }
        }
        if (cnt == 2 && deque.isEmpty()) {
            return true;
        }
        return false;
    }

}
// @lc code=end
