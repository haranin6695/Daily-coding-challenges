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