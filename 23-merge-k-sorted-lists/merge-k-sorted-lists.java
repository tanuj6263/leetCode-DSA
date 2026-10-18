import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Handle edge cases where input is empty
        if (lists == null || lists.length == 0) return null;

        // Convert the primitive array into a dynamic ArrayList so we can use .remove() and .add()
        List<ListNode> dynamicList = new ArrayList<>();
        for (ListNode node : lists) {
            if (node != null) { // Only add non-null lists
                dynamicList.add(node);
            }
        }

        // If all lists were null, return null
        if (dynamicList.size() == 0) return null;

        // Loop until only 1 merged list is left inside our dynamic list
        while (dynamicList.size() > 1) {
            // 1. Remove the last element
            ListNode a = dynamicList.remove(dynamicList.size() - 1);
            
            // 2. Remove the new last element
            ListNode b = dynamicList.remove(dynamicList.size() - 1);
            
            // 3. Merge them using your function
            ListNode c = merge(a, b);
            
            // 4. Add the merged list back to the collection
            dynamicList.add(c);
        }

        // Return the single remaining fully-merged list
        return dynamicList.get(0);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        // Ek dummy node banaya jo hamari nayi list ka starting point hoga
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy; // Nayi list ko aage badhane ke liye tracker
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        // Loop tabhi tak chalega jab tak DONO lists mein elements hain
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1; // Agar list1 ka element chhota hai, use jodo
                temp1 = temp1.next; // list1 ke pointer ko aage badhao
            } else {
                temp.next = temp2; // Agar list2 ka element chhota hai, use jodo
                temp2 = temp2.next; // list2 ke pointer ko aage badhao
            }
            temp = temp.next; // Apni nayi list ke tracker ko bhi aage badhao
        }

        // Agar list1 bachi hai to use direct jod do, nahi to list2 ko jod do
        if (temp1 != null) {
            temp.next = temp1;
        } else {
            temp.next = temp2;
        }

        // dummy.next hamari actual sorted list ka head (starting) hoga
        return dummy.next;
    }
}
