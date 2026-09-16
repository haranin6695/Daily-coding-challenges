problem:917
problem name:reverse only letters
category:easy
  class Solution {
    public String reverseOnlyLetters(String s) {
        char[] ch = s.toCharArray();
        StringBuilder letters = new StringBuilder();

        // Store all letters
        for (char c : ch) {
            if (Character.isLetter(c)) {
                letters.append(c);
            }
        }

        // Reverse the letters
        letters.reverse();

        // Put reversed letters back
        int index = 0;

        for (int i = 0; i < ch.length; i++) {
            if (Character.isLetter(ch[i])) {
                ch[i] = letters.charAt(index++);
            }
        }

        return new String(ch);
    }
}


problem:482
problem name:licence key formatting
category:easy
  class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int count = 0;
        s = s.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch == '-'){
                continue;
            }
            if(count == k){
                sb.append('-');
                count = 0;
            }
            sb.append(ch);
            count++; 
        }
        return sb.reverse().toString();
    }
}
