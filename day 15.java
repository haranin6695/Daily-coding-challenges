problem:945
problem name:minimum increament to make array unique
category:medium
solution:   
import java.util.Arrays;

class Solution {
    public int minIncrementForUnique(int[] nums) {
        if (nums.length == 0) return 0;
        
        Arrays.sort(nums);
        
        int moves = 0;
        // prev holds the smallest value the current element is allowed to take
        int prev = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= prev) {
                int needed = prev + 1;
                moves += needed - nums[i];
                prev = needed;
            } else {
                prev = nums[i];
            }
        }
        
        return moves;
    }
}


problem:1189
problem name:maximum number of balloons
category:easy
solution:
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int b = freq['b' - 'a'];
        int a = freq['a' - 'a'];
        int l = freq['l' - 'a'] / 2;
        int o = freq['o' - 'a'] / 2;
        int n = freq['n' - 'a'];
        
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}