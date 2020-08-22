/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (41.05%)
 * Likes:    1401
 * Dislikes: 308
 * Total Accepted:    222.9K
 * Total Submissions: 534.4K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * 
 * 
 */

// @lc code=start

//  * Definition for singly-linked list. 
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
    public ListNode partition(ListNode head, int x) {
        ListNode p, q, r;
        ListNode fakeHead = new ListNode(-1, head);
        p = fakeHead;
        q = fakeHead;

        while (q.next != null) {
            if (q.next.val < x) {
                if (p == q) {
                    p = p.next;
                    q = q.next;
                } else {
                    r = q.next;
                    q.next = r.next;
                    r.next = p.next;
                    p.next = r;
                    p = p.next;
                }
            } else {
                q = q.next;
            }
        }

        return fakeHead.next;
    }
}
// @lc code=end
