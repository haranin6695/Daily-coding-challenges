problem:821
problem name:Shortest Distance to a Character
category: easy
  class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        int ptr1 = 0;
        while (ptr1 < n && s.charAt(ptr1) != c) ptr1++;
        int idx = 0;
        for (; idx <= ptr1; idx++) {
            ans[idx] = Math.abs(idx - ptr1);
        }
        int ptr2 = 0;
        while (ptr2 < n) {
            while (ptr1 < n && s.charAt(ptr1) != c) ptr1++;
            ptr2 = ptr1 + 1;
            while (ptr2 < n && s.charAt(ptr2) != c) ptr2++;
            while (idx < n && idx <= ptr2) {
                if (ptr2 < n) {
                    ans[idx] = Math.min(Math.abs(idx - ptr1), Math.abs(idx - ptr2));
                } else {
                    ans[idx] = Math.abs(idx - ptr1);
                }
                idx++;
            }
            ptr1 = ptr2;
        }
        return ans;
    }
}


problem:824
problem name:Goat Latin
category: easy
  class Solution {
    public String toGoatLatin(String sentence) 
    {
        int front = 0;
        int move = 0;
        int rear = sentence.length();

        int count = 1;

        StringBuilder result = new StringBuilder();

        while(front < rear)
        {
            while(move < rear && sentence.charAt(move) != ' ')
            {
                move++;
            }

            String word = sentence.substring(front , move);

            move = move + 1;
            front = move;

            StringBuilder sb = new StringBuilder(word);

            if(isVowel(sb.charAt(0)))
            {
                sb.append("ma");
            }
            else 
            {
                char ch = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(ch);
                sb.append("ma");
            }

            
            for(int i=0;i<count;i++)
            {
                sb.append('a');
            }

            count++;

            result.append(sb);

            if(front < rear)
            {
                result.append(" ");
            }
        }

        return result.toString();
    }


    public boolean isVowel(char ch)
    {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A'|| ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
