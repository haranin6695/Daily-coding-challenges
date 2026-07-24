problem:405
problem name:convert a number to hexadecimal
category:easy
solution:
class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();
        
        // Treat num as unsigned 32-bit value using a long to avoid sign issues
        long n = num & 0xFFFFFFFFL;
        
        while (n > 0) {
            int digit = (int)(n & 0xF); // last 4 bits
            sb.append(hexDigits[digit]);
            n >>>= 4; // unsigned shift right by 4
        }
        
        return sb.reverse().toString();
    }
}


problem:406
problem name:quere reconstruction by height
category:medium
solution:
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort by height descending; for same height, sort by k ascending
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0]; // taller first
            return a[1] - b[1]; // if same height, smaller k first
        });
        
        List<int[]> result = new LinkedList<>();
        
        for (int[] p : people) {
            result.add(p[1], p); // insert at index k
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
