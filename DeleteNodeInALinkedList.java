/**
 * Write a function to delete a node (except for the tail) in a singly linked list, given only access to that node.
 * Suppose the linked list is 1->2->3->4 and you are given the third node with value 3, the linked list should
 * become 1->2->4 after calling your function.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *       int val;
 *       ListNode next;
 *       ListNode(int x) { val = x; }
 * }
 */
public class Solution {
   public void deleteNode() {
        node.val = node.next.val;
        node.next = node.next.next;
   }
 
