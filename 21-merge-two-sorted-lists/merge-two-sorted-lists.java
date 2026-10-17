import java.util.ArrayList;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ArrayList<ListNode> listCollection = new ArrayList<>();
        for (ListNode node : lists) {
            if (node != null) { 
                listCollection.add(node);
            }
        }

        if (listCollection.isEmpty()) {
            return null;
        }

        while (listCollection.size() > 1) {
            ListNode a = listCollection.get(listCollection.size() - 1);
            listCollection.remove(listCollection.size() - 1);
            
            ListNode b = listCollection.get(listCollection.size() - 1);
            listCollection.remove(listCollection.size() - 1);
            
            // Renamed method call here
            ListNode c = mergeTwoLists(a, b);
            
            listCollection.add(c);
        }

        return listCollection.get(0);
    }

    // Renamed from merge to mergeTwoLists to match LeetCode's driver program
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy; 
        ListNode temp1 = list1;
        ListNode temp2 = list2; 
        
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1; 
                temp1 = temp1.next; 
            } else {
                temp.next = temp2; 
                temp2 = temp2.next; 
            }
            temp = temp.next; 
        }
        
        if (temp1 != null) {
            temp.next = temp1;
        } else {
            temp.next = temp2;
        }
        
        return dummy.next;
    }
}
