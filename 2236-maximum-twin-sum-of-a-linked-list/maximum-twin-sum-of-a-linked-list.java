class Solution {
    public int pairSum(ListNode head) {
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
        int maxVal = 0;
        for (int i = 0; i < size / 2; i++) {
        
            int sum = arr[i] + arr[size - 1 - i];
            if (sum > maxVal) {
                maxVal = sum; 
            }
        }

        return maxVal;
    }
}
