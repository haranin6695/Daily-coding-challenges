import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;

        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int total = 0;
        for (int c : candies) {
            total += c;
        }

        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] ratings1 = {1, 0, 2};
        System.out.println("Example 1: " + solution.candy(ratings1) + " (Expected: 5)");

        int[] ratings2 = {1, 2, 2};
        System.out.println("Example 2: " + solution.candy(ratings2) + " (Expected: 4)");

        int[] ratings3 = {1, 2, 3, 4, 5};
        System.out.println("Extra test 1: " + solution.candy(ratings3) + " (Expected: 15)");

        int[] ratings4 = {5, 4, 3, 2, 1};
        System.out.println("Extra test 2: " + solution.candy(ratings4) + " (Expected: 15)");

        int[] ratings5 = {3, 3, 3};
        System.out.println("Extra test 3: " + solution.candy(ratings5) + " (Expected: 3)");

        int[] ratings6 = {5};
        System.out.println("Extra test 4: " + solution.candy(ratings6) + " (Expected: 1)");
    }
}