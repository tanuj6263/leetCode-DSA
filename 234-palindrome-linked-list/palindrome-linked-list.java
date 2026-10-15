import java.util.Arrays;

class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        ListNode temp = head;
        ListNode slow= head;
        ListNode fast= head;
        while(fast!=null&&fast.next!= null){
             fast=fast.next.next;
            slow= slow.next;  
        }
        ListNode curr= slow;
         ListNode prev = null;
        while (curr != null) {
            ListNode nextTemp = curr.next; 
            curr.next = prev;     
            prev = curr; 
            curr = nextTemp;  
        }
       ListNode firstHalf = head;
        ListNode secondHalf = prev; 
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false; 
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }  
        return true; 
    }
}
