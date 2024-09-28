import java.util.*;

/*
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

Example 1:
Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
 */

//solution
/*
1. if observe carefully, this problem is similar to two sum problem.
2. for each row, we are going to maintain a list with its freq.
3. for each col, we try to find did we already seen this list in row or not, if yes, then how many times?
 */

class Solution {

  public int equalPairs(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    Map<List<Integer>, Integer> map = new HashMap<>();

    //we are maintaining list and its frequency for row eg.
    /*
    [1, 2, 3]
    [4, 5, 6]
    [1, 2, 3]

    then we'll have the following map [1, 2, 3]-->2, [4, 5, 6]-->1
     */
    for (int i = 0; i < m; i++) {
      List<Integer> temp = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        temp.add(grid[i][j]);
      }

      map.merge(temp, 1, Integer::sum);
    }

    int ans = 0;

    /*
    [1, 2, 3]
    [4, 5, 6]
    [1, 2, 3]
    now we iterate and prepare list for column, eg. [1, 4, 1], [2, 5, 2],[3, 6, 3] and check whether we have already seen this or not.
    if already seen how many times?
     */
    for (int j = 0; j < n; j++) {
      List<Integer> temp = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        temp.add(grid[i][j]);
      }

      //if we already seen this list when preparing map on rows, we just need to add freq of it to our ans
      ans += map.getOrDefault(temp, 0);
    }

    return ans;
  }
}
