problem:153
problem name:Find Minimum in Rotated Sorted Array
category:medium
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];        
    }
}


problem:401
problem name: Binary Watch
category:easy
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        for (int hour = 0; hour < 12; hour++) {
            
            for (int minute = 0; minute < 60; minute++) {
                
                int totalBits = Integer.bitCount(hour) + Integer.bitCount(minute);
                
                if (totalBits == turnedOn) {
                    
                    String time = hour + ":" + 
                                  (minute < 10 ? "0" + minute : minute);
                    
                    result.add(time);
                }
            }
        }
        
        return result;
    }
}
