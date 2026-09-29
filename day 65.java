problem:841
problem name:Keys and Rooms
category:medium
  class Solution {
    boolean[] visited;
    int count = 0;
    List<List<Integer>> list;
    int n;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        n = rooms.size();
        visited = new boolean[n];
        list = rooms;
        dfs(0);
        return count == n;
    }
    void dfs(int v) {
        if(visited[v] == true) return;
        visited[v] = true;
        count++;
        if(count == n) return;
        for(int node : list.get(v)) {
            dfs(node);
        }
    }
}

problem:846
problem name:Hand of Straights 
category:medium
  class Solution {
    public boolean findsucessors(int[] hand, int groupSize, int i, int n) {
        int f = hand[i] + 1;
        hand[i] = -1;
        int count = 1;
        i += 1;
        while (i < n && count < groupSize) {
            if (hand[i] == f) {
                f = hand[i] + 1;
                hand[i] = -1;
                count++;
            }
            i++;
        }
        if (count != groupSize)
            return false;
        else
            return true;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0)
            return false;
        Arrays.sort(hand);
        int i = 0;
        for (; i < n; i++) {
            if (hand[i] >= 0) {
                if (!findsucessors(hand, groupSize, i, n))
                    return false;
            }
        }
        return true;
    }
}
