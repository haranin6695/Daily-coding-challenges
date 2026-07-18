problem :148
problem name:sorted list
category:medium
solution:
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Split the list into two halves using slow/fast pointers
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow.next;
        slow.next = null; // break the list into two parts
        
        // Recursively sort each half
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        // Merge the two sorted halves
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        tail.next = (l1 != null) ? l1 : l2;
        
        return dummy.next;
    }
}

problem:149
problem name:max points on line
category:hard
solution:
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        
        int maxCount = 1;
        
        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int duplicates = 0; // points identical to points[i]
            int localMax = 0;
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }
                
                // Normalize slope using GCD to avoid floating point issues
                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;
                
                // Ensure a consistent sign convention (e.g., dx is always non-negative;
                // if dx == 0, make dy positive)
                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }
                
                String key = dx + "_" + dy;
                slopeCount.put(key, slopeCount.getOrDefault(key, 0) + 1);
                localMax = Math.max(localMax, slopeCount.get(key));
            }
            
            // +1 for point i itself, plus any duplicate points on top of it
            maxCount = Math.max(maxCount, localMax + duplicates + 1);
        }
        
        return maxCount;
    }
    
    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a == 0 ? 1 : a; // avoid division by zero
    }
}

problem:160
problem name:interaction of two linked list
category:easy
solution:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode pA = headA;
        ListNode pB = headB;
        
        // When pA reaches end of A, redirect to headB.
        // When pB reaches end of B, redirect to headA.
        // They meet at the intersection, or both become null simultaneously.
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        
        return pA; // either the intersection node, or null
    }
}
