/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
*/

class Solution {

  Integer[] memo;

  public int minCostClimbingStairs(int[] cost) {
    memo = new Integer[cost.length];
    return Math.min(dp(cost, 0), dp(cost, 1));
  }

  public int dp(int[] nums, int i) {

    if (i >= nums.length)
      return 0;
    if (memo[i] != null)
      return memo[i];

    int cost = Integer.MAX_VALUE;

    // what are the choices we have, either 1 step or two step, and how current add
    // cost add to result.
    cost = Math.min(cost, nums[i] + dp(nums, i + 1));
    cost = Math.min(cost, nums[i] + dp(nums, i + 2));

    return memo[i] = cost;
  }
}
