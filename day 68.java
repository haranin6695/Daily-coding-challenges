problem:705
problem name:Design HashSet
category:easy
  class MyHashSet {
    private boolean[] mp;

    public MyHashSet() {
        mp = new boolean[1000001];
        Arrays.fill(mp, false);
    }

    public void add(int key) {
        mp[key] = true;
    }

    public void remove(int key) {
        mp[key] = false;
    }

    public boolean contains(int key) {
        return mp[key];
    }
}

problem:210
problem name:Course Schedule II
category:medium
  import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Indegree of each course
        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];

            graph.get(pre).add(course);
            indegree[course]++;
        }

        // Courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        // Topological Sort
        while (!queue.isEmpty()) {
            int course = queue.poll();

            result[index++] = course;

            for (int next : graph.get(course)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // Cycle exists
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }
}

