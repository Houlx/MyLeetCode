import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (46.35%)
 * Likes:    3924
 * Dislikes: 411
 * Total Accepted:    613.5K
 * Total Submissions: 1.3M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */

// @lc code=start
class Solution {
    Map<Character, List<String>> map = new HashMap<>() {
        {
            put('2', Arrays.asList("a", "b", "c"));
            put('3', Arrays.asList("d", "e", "f"));
            put('4', Arrays.asList("g", "h", "i"));
            put('5', Arrays.asList("j", "k", "l"));
            put('6', Arrays.asList("m", "n", "o"));
            put('7', Arrays.asList("p", "q", "r", "s"));
            put('8', Arrays.asList("t", "u", "v"));
            put('9', Arrays.asList("w", "x", "y", "z"));
        }
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || "".equals(digits))
            return res;
        combine(res, "", digits);
        return res;
    }

    public void combine(List<String> res, String comb, String digits) {
        if (digits.length() == 0) {
            res.add(comb);
        } else {
            char digit = digits.charAt(0);
            List<String> tmp = map.get(digit);
            String[] letters = tmp.toArray(new String[tmp.size()]);

            for (int i = 0; i < letters.length; i++) {
                String letter = letters[i];
                combine(res, comb + letter, digits.substring(1));
            }
        }
    }
}
// @lc code=end
