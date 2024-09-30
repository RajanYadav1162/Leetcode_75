
/*
 * You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
Change the direction from right to left or from left to right.
Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.

Example 1:

Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
Example 2:


Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4
Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
 */

/*
 * Solution idea is very intuitive,
 1. if we choose any node, what info we need to calculate the answer for current node.)
 2. how we reach at this node from parent. from left call or right call.
 3. if we've taken left call previously, then taking left will make new subproblem and taking right will be the step that we want to maximise the answer.
 */
class Solution {
  private int ans = 0;

  public int longestZigZag(TreeNode root) {

    // null - initially no dir movement has been done
    // 1 for left
    // 2 for right movement
    dfs(root, null, 0);
    return ans;
  }

  public void dfs(TreeNode root, Integer dir, int curr) {

    if (root == null)
      return;

    ans = Math.max(ans, curr);

    // initially we can move to left or right node of root.
    if (dir == null) {
      dfs(root.left, 1, curr + 1);
      dfs(root.right, 2, curr + 1);
    } else {

      // we reach this node by moving left from parent.
      // then taking left again will reset my current count of valid nodes. and right
      // will make increment of 1 in current count of valid nodes.
      if (dir == 1) {
        dfs(root.right, 2, curr + 1);
        dfs(root.left, 1, 1);

        // similarly if we are coming from right.......
      } else {
        dfs(root.left, 1, curr + 1);
        dfs(root.right, 2, 1);
      }
    }
  }
}
