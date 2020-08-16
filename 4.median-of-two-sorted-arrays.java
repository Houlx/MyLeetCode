import java.util.Arrays;

/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (29.31%)
 * Likes:    7105
 * Dislikes: 1100
 * Total Accepted:    685.1K
 * Total Submissions: 2.3M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] merged = Arrays.copyOf(nums1, len1 + len2);
        System.arraycopy(nums2, 0, merged, len1, len2);

        Arrays.sort(merged);

        if (((len1 + len2) & 1) == 1) {
            return merged[(len1 + len2) / 2];
        } else {
            return (merged[(len1 + len2) / 2] + merged[(len1 + len2) / 2 - 1]) / 2.0;
        }
    }
}
// @lc code=end
