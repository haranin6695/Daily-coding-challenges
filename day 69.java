problem:496
problem name:Next Greater Element I 
category:easy
  class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreater = new int[10001];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            nextGreater[nums2[i]] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreater[nums1[i]];
        }

        return nums1;
    }
}


problem:682
problem name:Baseball Game
category:easy
  class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String op : operations){
            if(op.equals("C")) stack.pop();
            else if(op.equals("D")) stack.push(stack.peek()*2);
            else if(op.equals("+")){
                int first = stack.pop();
                int second = stack.peek();

                stack.push(first);
                stack.push(first + second);
            }else{
                stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;

        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}
