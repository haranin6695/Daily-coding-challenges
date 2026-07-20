problem 177:
 problem name:Excel Sheet Column Number
 category:easy
 solution:
class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            int digit = c - 'A' + 1; // 'A' -> 1, 'B' -> 2, ..., 'Z' -> 26
            result = result * 26 + digit;
        }
        return result;
    }
}

problem:179
 problem name:largest number
 category:medium
 solution:

import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        // Custom comparator: place a before b if (a+b) > (b+a)
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        
        // Edge case: all zeros, e.g. ["0", "0"] -> "0" not "00"
        if (strs[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}
