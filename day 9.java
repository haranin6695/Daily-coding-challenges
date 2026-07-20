problem:189
problem name:rotate array
category:medium
solution:
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // handle k >= n
        
        reverse(nums, 0, n - 1);       // reverse entire array
        reverse(nums, 0, k - 1);       // reverse first k elements
        reverse(nums, k, n - 1);       // reverse remaining elements
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}


problem:190
problem name:reserve bits
category:easy
solution:
public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;              // make room for the next bit
            result |= (n & 1);         // grab the lowest bit of n, place it into result
            n >>>= 1;                  // unsigned shift n right to process next bit
        }
        return result;
    }
}