problem:709
problem name:to lower case
category:easy
solution:
class Solution {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}




problem:905
problem name:sort array by parity
category:easy
solution:
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            if (nums[left] % 2 == 0) {
                // already even, move on
                left++;
            } else {
                // swap with right pointer
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
        
        return nums;
    }
}
