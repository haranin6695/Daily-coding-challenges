problem:1137
problem name:nth tribonacci number
category:easy
solution:
class Solution {
    public int tribonacci(int n) {
        if(n==0)
        {
            return 0;
        }
        if(n<=2)
        {
            return 1;
        }
        int[] arr=new int[n+1];

        arr[0]=0;
        arr[1]=1;
        arr[2]=1;

        for(int i=3;i<=n;i++)
        {
            arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
        }
        return arr[n];
    }
}

problem:228
problem name:summery ranges
category:easy
solution:

class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> ranges = new ArrayList<>();
        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    ranges.add(Integer.toString(start));
                } else {
                    ranges.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
        }

        // Handle the last range
        if (start == nums[nums.length - 1]) {
            ranges.add(Integer.toString(start));
        } else {
            ranges.add(start + "->" + nums[nums.length - 1]);
        }

        return ranges;
    }
}






