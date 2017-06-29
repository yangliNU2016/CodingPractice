/**
 * Reverse a singly linked list.
 * Note: A linked list can be reversed either iteratively or recursively.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        Stack<Integer> st = new Stack<Integer>();
        while (head != null) {
            st.push(head.val);
            head = head.next;
        } 

        int reset = 0;
        ListNode ret = new ListNode(0);
        ListNode ptr = ret;
        while (!st.empty()) {
            ptr.val = st.pop();
            ptr.next = new ListNode(0);
            ptr = ptr.next;
        }
        
        ListNode trimPtr = ret;
        while(trimPtr.next.next != null) trimPtr = trimPtr.next;
        trimPtr.next = null;
        
        return ret;
    }
}
 
