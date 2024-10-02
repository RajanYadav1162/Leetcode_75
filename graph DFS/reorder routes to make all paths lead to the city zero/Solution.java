import java.util.*;

/*
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.


Example 1:


Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 2:


Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 3:

Input: n = 3, connections = [[1,0],[2,0]]
Output: 0
 

Constraints:

2 <= n <= 5 * 104
connections.length == n - 1
connections[i].length == 2
0 <= ai, bi <= n - 1
ai != bi
 */

//solution idea
/*
 * 1. we have to go through all the nodes to count the required re-arrangement so first we have to consider connection 
 *  as undirected then by exploring nodes, we have to check whether we have good edges are not.
 */

class Solution1 {

  // this is for adj list.(undirected)
  List<List<Integer>> list = new ArrayList<>();
  // this is for actual mapping check, eg. [1, 2] there is and edge from node 1 to
  // node 2, map will only contains 1-->2, but adj list contains both as
  // undirected edge.
  Map<Integer, Set<Integer>> map = new HashMap<>();
  int count = 0;

  public int minReorder(int n, int[][] A) {
    // build adj list from A.
    build(n, A);
    boolean[] visited = new boolean[n];
    // try to find rearrangements using dfs.
    dfs(0, null, visited);
    return count;
  }

  public void dfs(int src, Integer parent, boolean[] visited) {

    // when we are exploring after node 0, we have to check whether we have good
    // direction or not. if not count++.
    if (parent != null) {
      if (!map.getOrDefault(src, new HashSet<>()).contains(parent)) {
        count++;
      }
    }

    visited[src] = true;

    for (var nbh : list.get(src)) {
      if (!visited[nbh])
        dfs(nbh, src, visited);
    }
  }

  private void build(int n, int[][] A) {
    for (int i = 0; i < n; i++)
      list.add(new ArrayList<>());

    for (var e : A) {
      int s = e[0];
      int d = e[1];
      list.get(s).add(d);
      list.get(d).add(s);
      map.computeIfAbsent(s, (k) -> new HashSet<>()).add(d);
    }
  }
}

// more cleaner way to achieve the same things.
class Solution {
  List<List<Integer>> list = new ArrayList<>();

  public int minReorder(int n, int[][] A) {
    for (int i = 0; i < n; i++)
      list.add(new ArrayList<>());

    for (int[] a : A) {
      int s = a[0], d = a[1];
      list.get(s).add(d);
      list.get(d).add(-s);
    }

    return dfs(0, -1);
  }

  public int dfs(int src, int parent) {

    int count = 0;
    for (int v : list.get(src)) {
      // this will help us prevent boolean visited array creation.
      if (Math.abs(v) == parent)
        continue;

      // meaning we can not come to parent, we have to rearrange.
      if (v > 0)
        ++count;
      count += dfs(Math.abs(v), src);
    }

    return count;
  }
}
