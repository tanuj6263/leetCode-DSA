class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1, -1};
        
        // Ensure there are at least 3 nodes to have a critical point
        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }
        
        int idx = 1;
        int firstIdx = -1;
        int lastIdx = -1;
        int minDist = Integer.MAX_VALUE;
        
        ListNode a = head;
        ListNode b = a.next;
        ListNode c = b.next;
        
        while (c != null) {
            // Check if node b is a local maxima or local minima
            if ((b.val > a.val && b.val > c.val) || (b.val < a.val && b.val < c.val)) {
                
                // Track the very first critical point found
                if (firstIdx == -1) { 
                    firstIdx = idx;
                } else {
                    // Calculate distance from the immediate previous critical point
                    int dist = idx - lastIdx;
                    minDist = Math.min(dist, minDist);
                }
                
                // Update the last seen critical point index
                lastIdx = idx;
            }
            
            idx++;
            a = a.next;
            b = b.next;
            c = c.next;
        }
        
        // If fewer than two critical points were found, return [-1, -1]
        if (firstIdx == lastIdx) {
            return ans;
        }
        
        // Max distance is always the distance between the first and last critical point
        ans[0] = minDist;
        ans[1] = lastIdx - firstIdx;
        
        return ans;
    }
}
