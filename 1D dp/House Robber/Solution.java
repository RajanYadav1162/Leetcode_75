
/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.


Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 */

//Solution idea
/*
 * if you are some position i, either you can collect the coins from this position or skip it.
   if collected then go to next-next house, of If skipped go to next house.
 */

//recursrive dp
class Solution1 {
  private Integer[] memo;

  public int rob(int[] nums) {
    int n = nums.length;
    memo = new Integer[n];
    return dp(nums, 0);
  }

  public int dp(int[] nums, int i) {

    if (i >= nums.length)
      return 0;

    if (memo[i] != null)
      return memo[i];

    // robbing current house
    int rob = dp(nums, i + 2) + nums[i];
    int skip = dp(nums, i + 1);

    return memo[i] = Math.max(rob, skip);
  }
}

// iterative dp
class Solution {

  public int rob(int[] nums) {
    int n = nums.length;

    if (n == 1)
      return nums[0];

    // dp[i] --> max coins we can collect till 0...i.
    int[] dp = new int[n];

    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < n; i++) {
      // if we are taking dp[i-1] then we can not choose current coins.
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }

    return dp[n - 1];
  }
}
