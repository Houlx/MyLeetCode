/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (36.43%)
 * Likes:    1663
 * Dislikes: 107
 * Total Accepted:    249.3K
 * Total Submissions: 683.5K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Return the linked list sorted as well.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
 * 
 * 
 */

// @lc code=start
//
// //* Definition for singly-linked list.
// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

// */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);

        if (head == null || head.next == null) {
            return head;
        }

        ListNode q = head, pre = dummy;

        int flag = 0;

        while (pre != null && q != null) {
            if (q.next != null && q.next.val == q.val) {
                flag = 1;
                q = q.next;
            } else {
                q = q.next;
                pre = flag == 0 ? pre.next : pre;
                pre.next = q;
                flag = 0;
            }
        }
        return dummy.next;
    }
}
// @lc code=end
