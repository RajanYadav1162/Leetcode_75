/*
 Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
Example 1:


Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
Example 2:

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2
 
 */

//solution idea
/*
 * 1. we have to find sum of all nodes at each level, and if its maximum, that level is the answer.
   2. we can use for loop based on size, to iterate over all current level nodes in tree.
 */

class Solution {

  public int maxLevelSum(TreeNode root) {

    int level = 1;
    int ms = Integer.MIN_VALUE;
    int ans = 1;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      int cs = 0;
      // access all the current level nodes and compute its sum.
      for (int i = 0; i < size; i++) {
        var current = queue.poll();
        cs += current.val;
        if (current.left != null)
          queue.offer(current.left);
        if (current.right != null)
          queue.offer(current.right);
      }

      if (cs > ms) {
        ms = cs;
        ans = level;
      }
      ++level;
    }

    return ans;
  }
}
