import java.util.Arrays;

class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        
        int[] arr = new int[size];
        
        
        temp = head;
        int index = 0;
        while (temp != null) {
            arr[index] = temp.val;
            index++;
            temp = temp.next;
        }
        int[] arr1 = new int[size];
        for (int i = 0; i < size; i++) {
            arr1[i] = arr[size - 1 - i];
        }
        if (Arrays.equals(arr, arr1)) {
            return true;
        } else {
            return false;
        }
    }
}
