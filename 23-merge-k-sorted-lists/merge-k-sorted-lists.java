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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return divideAndConquer(lists, 0, lists.length - 1);
    }
    
    private ListNode divideAndConquer(ListNode[] lists, int start, int end) {
        // Base case: range is invalid
        if (start > end) {
            return null;
        }
        // Base case: only one list in the range
        if (start == end) {
            return lists[start];
        }
        
        // Find the midpoint to split the array
        int mid = start + (end - start) / 2;
        
        // Recursively divide the left and right halves
        ListNode left = divideAndConquer(lists, start, mid);
        ListNode right = divideAndConquer(lists, mid + 1, end);
        
        // Conquer: Merge the two sorted halves together
        return mergeTwoLists(left, right);
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Dummy node acts as a placeholder to easily build the new list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        // Standard two-pointer comparison
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        // Append remaining nodes from either list
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        
        return dummy.next;
    }
}
