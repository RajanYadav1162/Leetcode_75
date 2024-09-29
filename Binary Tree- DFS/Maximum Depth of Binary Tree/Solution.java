/*
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 * 
 * Input: root = [1,null,2]
 * Output: 2
 * 
 */

// Solution
/*
 * In such type of recursive que, just choose any middle position and try to
 * find how can I calculate answer for this node.
 */

class Solution {
  public int maxDepth(TreeNode root) {

    if (root == null)
      return 0;

    // leap of faith, maxDepth(root.left) gives answer of max depth from left
    // subtree, similarly rd = gives from right substring
    int ld = maxDepth(root.left);
    int rd = maxDepth(root.right);

    // since we have answer for left subtree, and right subtree, how can I calculate
    // ans for current node?

    return Math.max(ld, rd) + 1;
  }
}
