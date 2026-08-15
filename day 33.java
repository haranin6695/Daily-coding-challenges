problem:62
problem name:unique paths
category:medium
solution:
class Solution {

    private int solve(int i, int j, int m, int n, int[][] dp) {

        if (i >= m || j >= n) {
            return 0;
        }

        if (i == m - 1 || j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(i, j + 1, m, n, dp);
        int down = solve(i + 1, j, m, n, dp);

        return dp[i][j] = right + down;
    }

    public int uniquePaths(int m, int n) {

        if (m == 1 && n == 1) {
            return 1;
        }

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int right = solve(0, 1, m, n, dp);
        int down = solve(1, 0, m, n, dp);

        return right + down;
    }
problem:89
problem name:gray code
category:medium
solution:
  class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();

        int total = 1 << n;

        for (int i = 0; i < total; i++) {
            ans.add(i ^ (i >> 1));
        }

        return ans;
    }
}
}  
