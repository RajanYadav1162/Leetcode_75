
import java.util.*;
/*
 * You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
 */

/*
 * 1. This is typical Multi source BFS algorithm
   2. in the start we put all the rotten oranges in queue, and then aply bfs. 
   3. the last fresh oranges will rot at max time.
 */

class Solution {
  public int orangesRotting(int[][] grid) {
    int fresh = 0, rotten = 0;
    int m = grid.length, n = grid[0].length;
    int[][] A = new int[m][n];
    Queue<int[]> queue = new LinkedList<>();
    for (var item : A)
      Arrays.fill(item, Integer.MAX_VALUE);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          fresh++;
        } else if (grid[i][j] == 2) {
          rotten++;
          A[i][j] = 0;
          queue.offer(new int[] { i, j });
        } else
          A[i][j] = -1;
      }
    }

    if (fresh == 0)
      return 0;
    if (rotten == 0)
      return -1;
    while (!queue.isEmpty()) {
      var current = queue.poll();
      int r = current[0], c = current[1];

      for (int[] d : new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }) {
        int nr = r + d[0], nc = c + d[1];
        // A[nr][nc] = Integer.MAX_VALUE, will help us in identifying that we are
        // visiting for first time.
        if (nr < 0 || nc < 0 || nr >= m || nc >= n || A[nr][nc] == -1 || A[nr][nc] != Integer.MAX_VALUE)
          continue;
        A[nr][nc] = A[r][c] + 1;
        queue.offer(new int[] { nr, nc });
      }
    }

    int ans = -1;

    // basically checks, are there still any fresh oranges or not.
    for (var item : A) {
      for (var a : item) {
        if (a == Integer.MAX_VALUE)
          return -1;
        ans = Math.max(ans, a);
      }
    }

    return ans;
  }
}
