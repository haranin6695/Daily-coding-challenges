problem:693
problem name:binary number with alternating bits
category:easy
 class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
}
}



problem:728
problem name:self dividing numbers
category:easy
class Solution {
    private boolean check(int num) {
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (check(i)){
                list.add(i);
            }
        }
        return list;
    }
}
