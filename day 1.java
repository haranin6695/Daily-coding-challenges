problem 1:
problem name:gas circuit starting point
language:java
category:medium
solution:
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;   // overall surplus/deficit across full circuit
        int currTank = 0;    // running tank since last candidate start
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalTank += diff;
            currTank += diff;

            // If we run out of gas at station i, this segment can't work.
            // Every station from `start` to `i` is invalid as a start.
            if (currTank < 0) {
                start = i + 1;
                currTank = 0;
            }
        }

        return totalTank >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        int result1 = solution.canCompleteCircuit(gas1, cost1);
        System.out.println("Example 1: " + result1 + " (Expected: 3)");

        // Example 2
        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        int result2 = solution.canCompleteCircuit(gas2, cost2);
        System.out.println("Example 2: " + result2 + " (Expected: -1)");

        // Extra test: single station, exactly enough gas
        int[] gas3 = {5};
        int[] cost3 = {5};
        int result3 = solution.canCompleteCircuit(gas3, cost3);
        System.out.println("Extra test: " + result3 + " (Expected: 0)");
    }
}

problem 2:
problem name:candy
language:java
category:easy
solution:
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


problem:130
problem name:surrounding regions
language:java
category:medium
solution:
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        int m = board.length;
        int n = board[0].length;
        
        // Step 1: Mark all 'O's connected to the border as safe ('#')
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[m - 1][j] == 'O') dfs(board, m - 1, j);
        }
        
        // Step 2 & 3: Capture surrounded 'O's, restore safe ones
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';       // surrounded -> captured
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';       // safe -> restore
                }
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }
        
        board[i][j] = '#'; // mark as safe
        
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
