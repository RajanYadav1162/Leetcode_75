/*
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
 */

// Solution idea

/*
 * 1. first convert the adjacency matrix to adj list for ease.
   2. for each node, apply dfs, ane mark all the visited node.
   3. now for all the non -visited node, apply dfs again.
   4, depending on how many times we are able to call the dfs will be answer for connected componenets.
 */

class Solution {
  List<List<Integer>> list;

  public int findCircleNum(int[][] grid) {
    list = new ArrayList<>();
    int count = 0;
    build(grid);
    int n = grid.length;
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      // only non-visited node are going to push on dfs, because (1-->2-->3, 4) let
      // say this is the graph
      // then when apply dfs from '1', will mark 1 and 2 and 3 as visited, for 2 and 3
      // we don't need to do the dfs again.
      // now for 4 we have to do the dfs. so connected components will be 2.
      if (!visited[i]) {
        count++;
        dfs(i, visited);
      }
    }

    return count;
  }

  public void dfs(int src, boolean[] visited) {

    visited[src] = true;

    for (int nbh : list.get(src)) {
      if (!visited[nbh])
        dfs(nbh, visited);
    }
  }

  // to create adjacency list for graph.
  public void build(int[][] grid) {
    int len = grid.length;

    for (int i = 0; i < len; i++) {
      list.add(new ArrayList<>());
    }
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          list.get(i).add(j);
          list.get(j).add(i);
        }
      }
    }
  }
}
