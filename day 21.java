problem:217
problem name:contains duplicate
category:easy
solution:
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}



problem:575
problem name:distribute candies
category:easy
solution:
class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();

        for (var i : candyType) 
            set.add(i);
        
        var n = candyType.length / 2;

        if (set.size() >= n) 
            return n;
        else 
            return set.size();
    }
}

