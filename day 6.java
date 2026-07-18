problem :153
problem name:find minimum in rotated sorted array
category:medium
solution:
    class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // Minimum is somewhere to the right of mid
                left = mid + 1;
            } else {
                // nums[mid] <= nums[right] means mid could be the minimum,
                // or the minimum is somewhere to the left of mid
                right = mid;
            }
        }
        
        return nums[left];
    }
}




problem :155
problem name:min stack
category:medium
solution:
import java.util.*;

public class MinStack {
    private Deque<Long> stack;
    private long min;
    
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int value) {
        if (stack.isEmpty()) {
            min = value;
            stack.push(0L);
        } else {
            stack.push((long) value - min);
            if (value < min) {
                min = value;
            }
        }
    }
    
    public void pop() {
        long top = stack.pop();
        if (top < 0) {
            min = min - top;
        }
    }
    
    public int top() {
        long top = stack.peek();
        if (top < 0) {
            return (int) min;
        } else {
            return (int) (top + min);
        }
    }
    
    public int getMin() {
        return (int) min;
    }
    
    // Simple local test
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // -3
        minStack.pop();
        System.out.println(minStack.top());    // 0
        System.out.println(minStack.getMin()); // -2
    }
}


problem :165
problem name:compare version number
category:medium
solution:
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] rev1 = version1.split("\\.");
        String[] rev2 = version2.split("\\.");
        
        int n = Math.max(rev1.length, rev2.length);
        
        for (int i = 0; i < n; i++) {
            int v1 = (i < rev1.length) ? Integer.parseInt(rev1[i]) : 0;
            int v2 = (i < rev2.length) ? Integer.parseInt(rev2[i]) : 0;
            
            if (v1 < v2) return -1;
            if (v1 > v2) return 1;
        }
        
        return 0; // all revisions equal
    }
}
