import java.util.Deque;
import java.util.LinkedList;

/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 */


class Solution {

  //"3[a]2[bc]"
  public String decodeString(String s) {
    Deque<Character> stack = new LinkedList<>();
    StringBuilder ans = new StringBuilder();

    for (int i = s.length() - 1; i >= 0; i--) {
      char ch = s.charAt(i);
      if (ch == '[') {

        // sb will keep track of the string in the square bracket[abc]--> sb = abc;
        StringBuilder sb = new StringBuilder();
        while (stack.peek() != ']') {
          sb.append(stack.pop());
        }
        stack.pop();

        //since in the question it says that before '[', we'll have a number, we are building the number here.
        //since number can be range from 1-300, we've to keep iterating
        int j = i - 1;
        StringBuilder number = new StringBuilder();
        while (j >= 0 && Character.isDigit(s.charAt(j))) {
          number.insert(0, s.charAt(j));
          j--;
        }

        int n = Integer.parseInt(number.toString());
        StringBuilder temp = new StringBuilder(sb);
        temp.reverse();

        //depending on how many times we have to repeat, we repeat current string in bracket 'n' number of times.
        while (n-- > 0) {
          for (var c : temp.toString().toCharArray()) {
            stack.push(c);
          }
        }
        i = j + 1;
      } else {
        stack.push(ch);
      }
    }

    while (!stack.isEmpty()) {
      ans.append(stack.pop());
    }

    return ans.toString();
  }
}


