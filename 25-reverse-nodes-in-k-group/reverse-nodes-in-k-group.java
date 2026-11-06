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
    public ListNode reverseKGroup(ListNode head, int k) { 
        ListNode temp = head; 
        int count = 0; 
        
        // Check if at least k nodes exist in the current group
        while (count < k) { 
            if (temp == null) { 
                return head; // Less than k nodes left, leave them as-is
            } 
            temp = temp.next; 
            count++; // ✅ Increment count to avoid infinite loop
        } 
        
        // Recursively call for the rest of the linked list
        ListNode prevNode = reverseKGroup(temp, k); 
        
        // Reverse the current group of k nodes
        temp = head;
        count = 0; 
        while (count < k) { 
            ListNode next = temp.next; 
            temp.next = prevNode; 
            prevNode = temp; 
            temp = next; 
            count++; 
        } 
        
        return prevNode; 
    } 
}
