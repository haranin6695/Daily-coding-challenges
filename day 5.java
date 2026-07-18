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

problem:164
problem name:maximum gap
category:medium
solution:
import java.util.*;

class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        if (min == max) return 0; // all elements identical
        
        // Bucket setup: n-1 buckets, guaranteeing at least one empty bucket
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;
        
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        
        // Distribute numbers into buckets, tracking only min/max per bucket
        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
        }
        
        // Scan buckets left to right; gap = (this bucket's min) - (prev non-empty bucket's max)
        int maxGap = 0;
        int prevMax = min;
        
        for (int i = 0; i < bucketCount; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE) continue; // empty bucket, skip
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }
        
        return maxGap;
    }
}
