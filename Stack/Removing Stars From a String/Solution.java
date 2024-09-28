import java.util.*;

/*
You are given a string s, which contains stars *.

In one operation, you can:

Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.

Note:

The input will be generated such that the operation is always possible.
It can be shown that the resulting string will always be unique.


Example 1:

Input: s = "leet**cod*e"
Output: "lecoe"
Explanation: Performing the removals from left to right:
- The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
- The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
- The closest character to the 3rd star is 'd' in
 */


//solution idea
/*
1. we use stack to solve this problem, whenever something remove do something to adjacent(left, right). stack might be the one DS.
2. we are going to iterate over s, if its not a '*', we are gonna simply push it, otherwise pop from stack.
3. final ans will be the value in stack, don't forget stack values are always pop from top, so we need to reverse it.
 */
class Solution {

  public String removeStars(String s) {
    int n = s.length();
    Deque<Character> stack = new LinkedList<>();

    for (var ch : s.toCharArray()) {
      if (ch == '*') {
        stack.pop();
      } else {
        stack.push(ch);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    return sb.reverse().toString();
  }
}
