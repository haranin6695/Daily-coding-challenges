import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] tokens1 = {"2", "1", "+", "3", "*"};
        int result1 = solution.evalRPN(tokens1);
        System.out.println("Example 1: " + result1 + " (Expected: 9)");

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        int result2 = solution.evalRPN(tokens2);
        System.out.println("Example 2: " + result2 + " (Expected: 6)");

        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int result3 = solution.evalRPN(tokens3);
        System.out.println("Example 3: " + result3 + " (Expected: 22)");

        String[] tokens4 = {"7", "-2", "/"};
        int result4 = solution.evalRPN(tokens4);
        System.out.println("Extra test 1: " + result4 + " (Expected: -3)");

        String[] tokens5 = {"18"};
        int result5 = solution.evalRPN(tokens5);
        System.out.println("Extra test 2: " + result5 + " (Expected: 18)");
    }
}