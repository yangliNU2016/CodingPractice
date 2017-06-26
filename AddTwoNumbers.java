/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of 
 * their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ret.next = null;
        int add = 0;
        ListNode ref = ret;
        // Add l1 items with l2 items until one runs out of items
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if ((ref.val + sum) >= 10) add = 1;
            else add = 0;
            ref.val = (ref.val + sum) % 10;
            ref.next = new ListNode(add);
            ref = ref.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // Copy the rest of the items to the next list
        ListNode pt = null;
        if (l1 == null) pt = l2;
        else if (l2 == null) pt = l1;
        while (pt != null) {
            if ((ref.val + pt.val) >= 10) add = 1;
            else add = 0;
            ref.val = (ref.val + pt.val) % 10;
            ref.next = new ListNode(add);
            ref = ref.next;
            pt = pt.next;
        }
        // Solve End-with-Zero issue
        ListNode r = ret;
        while(r.next.next != null) {
            r = r.next;
        }
        if (r.next.val == 0) r.next = null;
        return ret;
    }
}
 
