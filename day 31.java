problem:806
problem name:number of lines to write string
category:easy
solution:
class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        if(s.length()==0)
        return new int[]{0,0};
        int[] ans=new int[]{1,0};
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            int temp=widths[s.charAt(i)-'a'];
            if(temp+sum<=100)
            {
                sum+=temp;
            }
            else 
            {
                ans[0]++;
                sum=temp;
            }
        }
        ans[1]=sum;
        return ans;
    }
}
problem:1122
problem name:relative sort array
category:easy
solution:
  class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        // Store frequency of every element
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Add elements in the order of arr2
        for (int num : arr2) {

            while (map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }

            map.remove(num);
        }

        // Add remaining sorted elements
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int key = entry.getKey();
            int freq = entry.getValue();

            while (freq > 0) {
                list.add(key);
                freq--;
            }
        }

        // Convert ArrayList to int[]
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
