problem:1365
problem name:How Many Numbers Are Smaller Than the Current Number
category:easy
  class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] > nums[j]) {
                    count++;
                }
            }

            ans[i] = count;
        }

        return ans;
    }
}

problem:1929
problem name:Concatenation of Array
category:easy
  class Solution {
    public int[] getConcatenation(int[] nums) {

        int ans[] = new int[nums.length * 2];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[i % nums.length];
        }

        return ans;
    }
}


problem:
problem name:
category:
