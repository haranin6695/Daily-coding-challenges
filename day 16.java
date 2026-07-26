problem:2574
problem name:left and right sum differences
category:easy
solution:
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int[] answer = new int[n];
        long leftSum = 0;
        
        for (int i = 0; i < n; i++) {
            long rightSum = totalSum - leftSum - nums[i];
            answer[i] = (int) Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        
        return answer;
    }
}

problem:3432
problem name:count partitions with even sum differences
category:easy
solution:
class Solution {
    public int countPartitions(int[] nums) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int n = nums.length;
        return (totalSum % 2 == 0) ? (n - 1) : 0;
    }
}