/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (53.04%)
 * Likes:    4227
 * Dislikes: 591
 * Total Accepted:    1M
 * Total Submissions: 1.9M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new sorted list. The new
 * list should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * 
 * 
 */

// @lc code=start

//Definition for singly-linked list.
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

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode start = (l1.val > l2.val) ? l2 : l1;
        ListNode head = start;
        ListNode anotherStart = (l1.val > l2.val) ? l1 : l2;
        // ListNode anotherHead = anotherStart;

        while (start.next != null) {
            while (anotherStart != null) {
                if (anotherStart.val >= start.val && anotherStart.val < start.next.val) {
                    ListNode tmp = anotherStart.next;
                    anotherStart.next = start.next;
                    start.next = anotherStart;
                    anotherStart = tmp;
                    start = start.next;
                } else {
                    break;
                }
            }
            start = start.next;
        }

        if (anotherStart != null) {
            start.next = anotherStart;
        }

        return head;
    }
}

// class Solution {
// public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
// if (l1 == null) {
// return l2;
// }
// if (l2 == null) {
// return l1;
// }
// if (l1.val < l2.val) {
// l1.next = mergeTwoLists(l1.next, l2);
// return l1;
// } else {
// l2.next = mergeTwoLists(l1, l2.next);
// return l2;
// }
// }
// }
// @lc code=end
