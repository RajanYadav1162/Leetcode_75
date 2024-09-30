/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
 * of itself according to the LCA definition.
 * Example 3:
 * 
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if (root == null)
      return null;

    // if we found a node just return it.
    if (root.val == p.val || root.val == q.val)
      return root;

    // think about for any node, we get something form its left subtree and right
    // subtree,
    var left = lowestCommonAncestor(root.left, p, q);
    var right = lowestCommonAncestor(root.right, p, q);

    // meaning for this node(root), we get an value from left call and right call,
    // so this root is the ans.
    if (left != null && right != null)
      return root;

    // we only get the value from left call only, since there are always ancestor
    // exist, another value will be somewhere below of this node.
    else if (left != null)
      return left;
    // we only get the value from right call only, since there are always ancestor
    // exist, another value will be somewhere below of this node.
    else if (right != null)
      return right;

    // this should never triggered since we always have the answer.
    return null;
  }
}
