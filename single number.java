class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {2, 2, 1};
        System.out.println("Example 1: " + solution.singleNumber(nums1) + " (Expected: 1)");

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Example 2: " + solution.singleNumber(nums2) + " (Expected: 4)");

        int[] nums3 = {1};
        System.out.println("Example 3: " + solution.singleNumber(nums3) + " (Expected: 1)");

        // Extra test: negative numbers
        int[] nums4 = {-1, -1, -2};
        System.out.println("Extra test 1: " + solution.singleNumber(nums4) + " (Expected: -2)");

        // Extra test: larger array
        int[] nums5 = {7, 3, 5, 4, 5, 3, 4};
        System.out.println("Extra test 2: " + solution.singleNumber(nums5) + " (Expected: 7)");
    }
}