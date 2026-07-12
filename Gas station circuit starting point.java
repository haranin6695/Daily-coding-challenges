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