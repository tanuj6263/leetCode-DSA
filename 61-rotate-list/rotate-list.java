/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Fix 1: Handle edge cases to prevent division by zero or NullPointerExceptions
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Fix 2: Stop at the last node (tail.next != null) instead of passing it
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) { 
            len++;
            tail = tail.next;
        }

        // Fix 3: Adjust k relative to len, and check if effective rotation is 0
        k %= len;
        if (k == 0) {
            return head;
        }

        // Fix 4: Safely connect the tail to the head to close the loop
        tail.next = head;

        // Fix 5: Replace the broken recursion with an iterative step to find the new cut-off point
        ListNode newTail = head;
        for (int i = 0; i < len - k - 1; i++) {
            newTail = newTail.next;
        }

        // Fix 6: Establish the new head and break the circular connection
        head = newTail.next;
        newTail.next = null;

        return head;
    }
}
