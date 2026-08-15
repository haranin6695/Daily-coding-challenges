problem:54
problem name:spiral amtrix
category:medium
solution:
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Top row
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // Right column
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                // Bottom row
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // Left column
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
problem:56
problem name:merge intervals
category:medium
solution:
  class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            // Overlap condition: current start <= previous end
            if (intervals[i][0] <= prev[1]) {
                // Merge intervals
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                // No overlap, add previous interval to result
                merged.add(prev);
                prev = intervals[i];
            }
        }

        merged.add(prev); // Add the last interval
        return merged.toArray(new int[merged.size()][]);
    }
}










problem:
problem name:
category:
solution:
