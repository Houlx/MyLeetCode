import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (35.10%)
 * Likes:    3289
 * Dislikes: 228
 * Total Accepted:    622.6K
 * Total Submissions: 1.8M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, remove the n-th node from the end of list and return
 * its head.
 * 
 * Example:
 * 
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * 
 * Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

// class ListNode {
// int val;
// ListNode next;

// ListNode() {
// }

// ListNode(int val) {
// this.val = val;
// }

// ListNode(int val, ListNode next) {
// this.val = val;
// this.next = next;
// }
// }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode p = head;
        while (p != null) {
            deque.push(p);
            p = p.next;
        }
        int i = 0;
        while (i++ < n) {
            deque.pop();
        }
        ListNode q;
        if (!deque.isEmpty()) {
            q = deque.pop();
            q.next = q.next.next;
        } else {
            head = head.next;
        }
        return head;
    }
}
// @lc code=end
