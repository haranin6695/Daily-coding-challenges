problem:804
problem name:Unique Morse Code Words
category:easy
  class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] code = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
            "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };

        Set<String> set = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(code[c - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}


problem:657
problem name:Robot Return to Origin
category:easy
  class Solution {
    public boolean judgeCircle(String moves) {
        int count_v = 0, count_h = 0;

        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);

            if (ch == 'U') count_v++;
            else if (ch == 'D') count_v--;
            else if (ch == 'R') count_h++;
            else count_h--;
        }

        return count_v == 0 && count_h == 0;
    }
}


problem:
problem name:
category:
