
/*
 * You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

Example 1:

Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Example 2:


Input: root = [4,2,7,1,3], val = 5
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107
 */

//solution idea 
/*
 * 1. if you have find a node with value == val, return the node(base case)
 * 2. now choose any node, we'll get something from left and right, if we get left != null, meaning left call contains the answer otherwise right call contains the answer.
 */

class Solution {
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null)
      return null;
    if (root.val == val)
      return root;

    TreeNode left = null, right = null;
    // meaning we have to find root with values lesser then root.val
    if (root.val >= val)
      left = searchBST(root.left, val);

    // if current node val < target val, there is no pointing going to left
    if (root.val < val)
      right = searchBST(root.right, val);

    if (left != null)
      return left;

    if (right != null)
      return right;

    return null;

  }
}
