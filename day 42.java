problem:69
problem name:sqrt(x)
category:easy
  class Solution {
    public int mySqrt(int x) {
        int low = 0, high = x, ans = -1;
        while (low <= high) {
            long mid = (low + high) / 2;
            long midsq = mid * mid;
            if (midsq == x)
                return (int)mid;
            else if (midsq > x)
                high = (int)mid - 1;
            else {
                ans = (int)mid;
                low = (int)mid + 1;
            }
        }
        return ans;
    }
}



problem:171
problem name:excel sheet column number
category:easy
  class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result = result * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
