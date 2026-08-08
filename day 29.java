problem : 1281
problem name: Subtract the Product and Sum of Digits of an Integer
category:easy
solution:
  class Solution {
    public int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;
        while(n != 0){
            int lastDigit = n%10;
            prod = prod * lastDigit;
            sum = sum + lastDigit;
            n = n/10;
        }
        return prod - sum;
    }
}

problem : 1342
problem name:Number of steps to reduce a Number to zero
category:easy
solution:
  class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            count++;
        }
        return count;
    }
}
