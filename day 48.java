problem:357
problem name:count numbers with unique digits
category:medium
  class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int total = 10;
        int prod = 9;
        for (int i = 2; i < n + 1; i++) {
            total += prod * (11 - i);
            prod *= 11 - i;
        }
        return total;
    }
}


problem:506
problem name:relative ranking
category:easy
  class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        int n = score.length;
        
        int[][] sortedPairs = new int[n][2];
        for (int i = 0 ; i < n ; i++) sortedPairs[i] = new int[] {i, score[i]};
        
        Arrays.sort(sortedPairs, (x, y) -> (y[1] - x[1]));
        
        String[] ans = new String[n];
        
        for (int i = 0 ; i < n ; i++) {
            
            if (i == 0) {
                ans[sortedPairs[i][0]] = "Gold Medal";
            } else if (i == 1) {
                ans[sortedPairs[i][0]] = "Silver Medal";
            } else if (i == 2) {
                ans[sortedPairs[i][0]] = "Bronze Medal";
            } else {
                ans[sortedPairs[i][0]] = String.valueOf(i+1);
            }
        }
        
        return ans;
    }
}
  
