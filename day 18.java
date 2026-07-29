problem:392
problem name:is subsquence
category:easy
solution:
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n = s.length(), m = t.length();
        
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        
        return i == n;
    }
}


problem:1323
problem name:maximum 69 number
category:easy
solution:
class Solution {
    public int maximum69Number (int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break;
            }
        }
        
        return Integer.parseInt(new String(digits));
    }
}
