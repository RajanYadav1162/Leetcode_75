
import java.util.*;
/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.



Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

 */


//solution
/*
1. we have to only focus on negative weight asteroid,
2. we have to find collision state, and follow as the questions asked,
3. hard to come up with questions,
 */
class Solution {

  public int[] asteroidCollision(int[] A) {
    Deque<Integer> stack = new LinkedList<>();

    for (int a : A) {

      //collision happens, depending whats the state after collision, we are going to change 'a' value.
      // by question inputs, a != 0, thats why we are choosing a  = 0
      while (stack.size() > 0 && stack.peek() > 0 && a < 0) {

        int val = stack.peek() + a;
        if (val < 0) {
          stack.pop();
        } else if (val > 0) {
          a = 0;
        } else {
          a = 0;
          stack.pop();
        }
      }

      //this means, either collision happens of same size, or negative weight asteroid has lesser weight.so we don't need to add that in the stack
      if (a != 0) {
        stack.push(a);
      }
    }

    List<Integer> ans = new ArrayList<>();

    while (stack.size() > 0) {
      ans.add(stack.pop());
    }

    Collections.reverse(ans);

    return ans.stream().mapToInt(Integer::intValue).toArray();
  }
}
