problem:268
problem name:missing number
category:easy
solution:

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
}

problem:283
problem name:move zeroes
category:easy
solution:
class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        
        // Move all non-zero elements to the front, preserving order
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        
        // Fill the rest of the array with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
