problem:151
problem name:reverse words in a string
categery:medium
language :java
solution:
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}


problem:152
problem name:maximum product subarray
category:medium
soluyion:
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
