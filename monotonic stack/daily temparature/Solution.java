/*
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 
  
 
 Example 1:
 
 Input: temperatures = [73,74,75,71,69,72,76,73]
 Output: [1,1,4,2,1,1,0,0]
 Example 2:
 
 Input: temperatures = [30,40,50,60]
 Output: [1,1,1,0]
 Example 3:
 
 Input: temperatures = [30,60,90]
 Output: [1,1,0]
  
 */

import java.util.*;

class Solution {
  public int[] dailyTemperatures(int[] T) {

    // greater element found -> decreasing MS
    // next greater--> run loop from end
    int n = T.length;
    int[] ans = new int[n];

    Deque<Integer> stack = new LinkedList<>();

    for (int i = n - 1; i >= 0; i--) {

      while (stack.size() > 0 && T[i] >= T[stack.peek()]) {
        stack.pop();
      }

      ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;

      stack.push(i);
    }

    return ans;
  }
}
