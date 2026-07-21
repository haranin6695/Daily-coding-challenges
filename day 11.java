problem:1480
problem name:running sum of 1d array
category:easy
solution:
class Solution {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }
}


problem:1295
problem name:find numbers with even number ofdigits
category:easy
solution:
class Solution {
    public int findNumbers(int[]a) {
        int count=0;
     
        for(int b : a){
            int c=0;
            int n=b;
            while(n>0){
                n/=10;
                c=c+1;
             }
            if(c%2==0){
                count++;
            }
        }
       return count; 
    }
}