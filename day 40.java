problem:1480
problem name:Running sum of 1d Array
category:easy
  class Solution {
    public int[] runningSum(int[] nums) {

        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i-1]+nums[i];

        }
        return nums;
    }
}



problem:283
problem name:move zeroes
category:easy
class Solution {
    public void moveZeroes(int[] nums) {

        int k = 0;

        for(int num : nums){

            if(num != 0){
                nums[k++] = num;
            }
        }

        while(k < nums.length){
            nums[k++] = 0;
        }
    }
}
