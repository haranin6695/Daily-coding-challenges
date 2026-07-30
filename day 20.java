problem:3873
problem name:mirror distance of an integer
category:easy
solution:
class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    public int reverse(int n){
        int t = 0;
        while(n > 0){
            t *= 10;
            t += n % 10;
            n /= 10;
        }
        return t;
    }
}



problem:1009
problem name:complement of base 10 integer
cetegory:easy
solution:
class Solution {
    publaic int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int mask = (1 << (32 - Integer.numberOfLeadingZeros(n))) - 1;
        return n ^ mask;
    }
}

