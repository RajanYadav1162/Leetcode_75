
import java.util.*;

/*
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

//solution
/*
 * 1. idea is to use map, one each level there is only node need to be there. 
   2. so one each level, we can see maximum of two nodes, we just need to override the value at each level with BFS.
 */
class Solution {
  public List<Integer> rightSideView(TreeNode root) {

    if (root == null)
      return new ArrayList<>();

    Map<Integer, Integer> map = new HashMap<>();
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(0, root));

    while (queue.size() > 0) {
      var current = queue.poll();

      // if map has already one value at current level, override it to see the updated
      // value.
      map.put(current.level(), current.node().val);

      if (current.node().left != null)
        queue.offer(new Pair(current.level() + 1, current.node().left));

      if (current.node().right != null)
        queue.offer(new Pair(current.level() + 1, current.node().right));
    }

    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < map.size(); i++)
      ans.add(null);

    for (var entry : map.entrySet()) {
      ans.set(entry.getKey(), entry.getValue());
    }

    return ans;

  }
}

record Pair(int level, TreeNode node) {
}
