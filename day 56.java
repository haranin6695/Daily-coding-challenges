problem:485
problem name:max consecutive ones
category:easy
  class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 1) // if nums[i] = 1, increment count and track maxCount
            {
                count++;
                maxCount = Math.max(maxCount, count);
            }
            else    // if nums[i] = 0, reset count to zero.
                count = 0;
        }

        return maxCount;
    }
}

problem:495
problem name:teemo attacking
category:easy
  class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        for (int i = 0; i < timeSeries.length-1; i++) {
            // if next attack occurs before current duration ends, include the difference
            if (timeSeries[i+1] <= timeSeries[i] + duration-1) {
                total += timeSeries[i+1] - timeSeries[i];
            } else { // add duration normally
                total += duration;
            }
        }
        total += duration; // include last attack from teemo
        return total;
    }
}
