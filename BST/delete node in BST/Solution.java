
/*
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.

Example 1:
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: []
 
 */

//Solution idea
/*
 * 1. think about three cased, single child, two child and no child.
   2. for two child, we have to find lmax, override node value and delete the lmax key value node from node.left subtree.
 */
class Solution {
  public TreeNode deleteNode(TreeNode root, int key) {

    if (root == null)
      return null;

    if (root.val == key) {
      // two child
      if (root.left != null && root.right != null) {
        int lmx = max(root.left);
        root.val = lmx;
        root.left = deleteNode(root.left, lmx);
        return root;
        // no child
      } else if (root.left == null && root.right == null) {
        return null;
        // one child
      } else {
        if (root.left == null)
          return root.right;
        else
          return root.left;
      }
    }

    if (root.val > key)
      root.left = deleteNode(root.left, key);
    if (root.val < key)
      root.right = deleteNode(root.right, key);

    return root;

  }

  private int max(TreeNode root) {
    if (root.right == null)
      return root.val;
    return max(root.right);
  }
}
