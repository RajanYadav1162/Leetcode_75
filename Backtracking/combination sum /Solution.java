import java.util.*;

/*
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 * 
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain
 * the same combination twice, and the combinations may be returned in any
 * order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 */

//In backtracking problem, if we are able to draw the recursive tree, we are good.
/*
 * 1. at first level, we have calls of 1 , 2 ,3, 4, 5, 6, .....9
   2. at second level . for 1, we have option of choose 2, 3, 4, 5, 6....9, for 5--> 6, 7, 8, 9.....
 */

class Solution {
  private int k;
  private int n;
  List<List<Integer>> ans = new ArrayList<>();

  public List<List<Integer>> combinationSum3(int k, int n) {
    this.k = k;
    this.n = n;

    dfs(1, new ArrayList<>(), 0);
    ;

    return ans;

  }

  public void dfs(int s, List<Integer> psf, int cs) {

    // if we found k size list with sum == cs, this is a valid list to add in our
    // final answer.
    if (psf.size() == k && cs == n) {
      ans.add(new ArrayList<>(psf));
      return;
    }

    // out of bound conditions
    if (cs > n || s > 9)
      return;

    for (int i = s; i <= 9; i++) {
      psf.add(i);
      // if we already taken i,then for next level reccur it from (i+1).
      dfs(i + 1, psf, cs + i);
      psf.remove(psf.size() - 1);
    }
  }
}
