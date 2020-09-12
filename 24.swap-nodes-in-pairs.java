/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (49.92%)
 * Likes:    2252
 * Dislikes: 169
 * Total Accepted:    468.8K
 * Total Submissions: 937.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * 
 */

// @lc code=start

//* Definition for singly-linked list.
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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(-1, head);
        ListNode h = fakeHead, a = head, b = head.next;
        while (b != null) {
            a.next = b.next;
            b.next = a;
            h.next = b;
            h = a;
            a = a.next;
            if (a != null)
                b = a.next;
            else
                b = null;
        }
        return fakeHead.next;
    }
}
// @lc code=end
