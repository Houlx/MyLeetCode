/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (33.59%)
 * Likes:    8302
 * Dislikes: 2120
 * Total Accepted:    1.4M
 * Total Submissions: 4.2M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0, null);
        ListNode p = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int preSum = l1.val + l2.val + carry;
            // l1.val = preSum % 10;
            ListNode n = new ListNode(preSum % 10, null);
            p.next = n;
            p = p.next;
            if (preSum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int preSum = l1.val + carry;
            ListNode n = new ListNode(preSum % 10, null);
            p.next = n;
            p = p.next;
            if (preSum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            int preSum = l2.val + carry;
            ListNode n = new ListNode(preSum % 10, null);
            p.next = n;
            p = p.next;
            if (preSum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            l2 = l2.next;
        }
        if (carry == 1) {
            ListNode n = new ListNode(1, null);
            p.next = n;
            p = p.next;
        }
        return dummy.next;
    }
}

// 3 while can be written as
// ListNode m=l1,n=l2;
// while(m!=null||n!=null){
// int x=(m!=null)?m.val:0;
// int y=(n!=null)?n.val:0;

// int preSum=x+y+carry;
// p.next=new ListNode(preSum%10);
// carry=(preSum>=10)?1:0;
// p=p.next;
// if(m.next!=null){m=m.next;}
// if(n.next!=null){n=n.next;}
// }
// @lc code=end
