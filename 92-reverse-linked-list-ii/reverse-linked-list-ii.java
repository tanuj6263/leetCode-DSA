class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode before = dummy;
        for (int i = 1; i < left; i++) {
            before = before.next;
        }
        
        ListNode curr = before.next;
        ListNode nextTemp = null;
        
        for (int i = 0; i < right - left; i++) {
            nextTemp = curr.next;
            curr.next = nextTemp.next;
            nextTemp.next = before.next;
            before.next = nextTemp;
        }
        
        return dummy.next;
    }
}
