problem:143
problem name:Reorder List
category:medium
class Solution {

    public void reorderList(ListNode head) {

        if(head == null || head.next == null){
            return;
        }

        // Step 1: Find Middle

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split List

        ListNode second = slow.next;
        slow.next = null;

        // Step 3: Reverse Second Half

        ListNode prev = null;

        while(second != null){

            ListNode next = second.next;

            second.next = prev;

            prev = second;
            second = next;
        }

        second = prev;

        // Step 4: Merge Both Halves

        ListNode first = head;

        while(second != null){

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
problem:373
problem name:Find K Pairs with Smallest Sums
category:medium
  import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    private static class Pair {
        int sum;
        int i;
        int j;

        public Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();
        // storing the length of nums1 to use it in a loop later
        int listLength = nums1.length;
        // declaring a min-heap to keep track of the smallest sums
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.sum - b.sum);

        // iterate over the length of nums1
        for (int i = 0; i < Math.min(k, listLength); i++) {
            // computing sum of pairs of all elements of nums1 with first index
            // of nums2 and placing it in the min-heap
            minHeap.add(new Pair(nums1[i] + nums2[0], i, 0));
        }

        int counter = 0;
        // iterate over elements of min-heap and only go up to k
        while (!minHeap.isEmpty() && counter < k) {
            // placing sum of the top element of min-heap
            // and its corresponding pairs in i and j
            Pair pair = minHeap.poll();
            int i = pair.i;
            int j = pair.j;
            // add pairs with the smallest sum in the new list
            pairs.add(Arrays.asList(nums1[i], nums2[j]));
            // increment the index for the 2nd list, as we've
            // compared all possible pairs with the 1st index of nums2
            int nextElement = j + 1;
            // if next element is available for nums2 then add it to the heap
            if (nums2.length > nextElement) {
                minHeap.add(new Pair(nums1[i] + nums2[nextElement], i, nextElement));
            }
            counter++;
        }
        // return the pairs with the smallest sums
        return pairs;
    }
}
