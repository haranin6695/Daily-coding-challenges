import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Arrays;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // empty string is always "breakable"

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // If s[0..j) is breakable AND s[j..i) is a valid word
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check further j for this i
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println("Example 1: " + solution.wordBreak(s1, wordDict1) + " (Expected: true)");

        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println("Example 2: " + solution.wordBreak(s2, wordDict2) + " (Expected: true)");

        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("Example 3: " + solution.wordBreak(s3, wordDict3) + " (Expected: false)");

        // Extra test: single word match
        String s4 = "cars";
        List<String> wordDict4 = Arrays.asList("car", "ca", "rs");
        System.out.println("Extra test 1: " + solution.wordBreak(s4, wordDict4) + " (Expected: true)");

        // Extra test: no valid segmentation
        String s5 = "abcd";
        List<String> wordDict5 = Arrays.asList("a", "abc", "b", "cd");
        System.out.println("Extra test 2: " + solution.wordBreak(s5, wordDict5) + " (Expected: true)");
    }
}
