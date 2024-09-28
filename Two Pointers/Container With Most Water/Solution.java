/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */

//Solution
/*
1. first just focus on any consecutive two bars, how can we calculate how much water it can store?
2. well it will be min between two bars, and distance between them(Area of rectangle).
3. similar in greedy way, we first maximize the width of of two bars, and then try to find two most optimized bars.because
   since we're already maximising the distance between them, we just need to find the bars.
 */

class Solution {

  public int maxArea(int[] A) {
    int i = 0, j = A.length - 1;
    int ans = 0;
    while (i < j) {

      //we have to maximise area of rectangle, (j-i)-->Breadth is already maximse, (Length*Breadth), for length we choose the min one.
      ans = Math.max(ans, Math.min(A[i], A[j]) * (j - i));
      if (A[i] <= A[j]) {
        i++;
      } else {
        j--;
      }
    }

    return ans;
  }
}
