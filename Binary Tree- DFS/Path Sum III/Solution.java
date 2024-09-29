/*
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
Example 1:

Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
 

Constraints:

The number of nodes in the tree is in the range [0, 1000].
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000
 */

/*
 * 1. Since constraints are quite low, we can use O(n^2) solution, 
   2. using dfs go to each node, and try to find out how many sum we can make that equals to target.
 */
class Solution1 {
  private int count = 0;
  private int T;

  public int pathSum(TreeNode root, int T) {
    this.T = T;
    dfs(root);
    return count;
  }

  public void dfs(TreeNode root) {
    if (root == null)
      return;
    count(root, 0);
    dfs(root.left);
    dfs(root.right);
  }

  public void count(TreeNode root, long cs) {

    if (root == null) {
      return;
    }

    // careful here!, initially cs ==0, but we are at root node.
    if (cs + root.val == T)
      count++;

    count(root.left, cs + root.val);
    count(root.right, cs + root.val);

  }

}

// optimised solution using subarray with target sum logic.

class Solution {
  private Map<Long, Integer> map;
  private int count = 0;
  private int T;

  public int pathSum(TreeNode root, int T) {
    this.T = T;
    this.map = new HashMap<>();
    map.put(0l, 1);
    dfs(root, 0);
    return count;
  }

  public void dfs(TreeNode root, long cs) {

    if (root == null)
      return;

    var sum = cs + root.val;
    if (map.containsKey(sum - T)) {
      // careful here.
      count += map.get(sum - T);
    }

    map.merge(sum, 1, Integer::sum);
    dfs(root.left, sum);
    map.merge(sum, -1, Integer::sum);
    if (map.get(sum) == 0)
      map.remove(sum);
    map.merge(sum, 1, Integer::sum);
    dfs(root.right, sum);
    map.merge(sum, -1, Integer::sum);
    if (map.get(sum) == 0)
      map.remove(sum);

  }
}
