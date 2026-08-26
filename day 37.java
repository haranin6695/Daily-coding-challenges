problem:1431
problem name:Kids With the Greatest Number of Candies
category:easy
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }
        
        List<Boolean> result = new ArrayList<>();
        
        for (int candy : candies) {
            if (candy + extraCandies >= maxCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;
    }
}


problem: 1108
problem name: Defanging an IP Address
category:easy
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
