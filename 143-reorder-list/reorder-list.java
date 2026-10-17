class Solution {
    public void reorderList(ListNode head) {
        // Base case: Agar list khali hai ya sirf 1 node hai, to kuch nahi karna
        if (head == null || head.next == null) {
            return; // 1. Void return type sahi kiya
        }
        
        // Step 1: Slow aur Fast pointers se middle node dhoondho
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // Step 2: Second half ko reverse karo
        ListNode curr = slow.next;
        slow.next = null; // 2. Zaroori step: List ko beech se do tukdo mein toda
        
        ListNode prev = null;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        // Step 3: Dono halves ko ek-ek karke merge (mix) karo
        ListNode first = head;   // Pehli half ka head
        ListNode second = prev;  // Dusri reversed half ka head
        
        while (second != null) {
            // Aage ke nodes ka reference save kar lo taaki link na toote
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            
            // Zig-zag connection banao
            first.next = second;
            second.next = temp1;
            
            // Pointers ko aage badhao
            first = temp1;
            second = temp2;
        }
    }
}
