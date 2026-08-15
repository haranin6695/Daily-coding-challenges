problem:152
problem name:maximum product summary
category:medium
solution:
  class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            
            // If num is negative, swapping curMax and curMin 
            // effectively flips the roles: max becomes min, min becomes max
            if (num < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            
            curMax = Math.max(num, curMax * num);
            curMin = Math.min(num, curMin * num);
            
            maxProd = Math.max(maxProd, curMax);
        }
        
        return maxProd;
    }
}
problem:300
problem name:longest increasing sequence
category:medium
solution:
  class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
