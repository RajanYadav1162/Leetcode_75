/*
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day, and an integer fee representing a transaction fee.
 * 
 * Find the maximum profit you can achieve. You may complete as many
 * transactions as you like, but you need to pay the transaction fee for each
 * transaction.
 * 
 * Note:
 * 
 * You may not engage in multiple transactions simultaneously (i.e., you must
 * sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and sale.
 * 
 * 
 * Example 1:
 * 
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Example 2:
 * 
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 * 
 */

class Solution {

  private Integer[][] memo;

  public int maxProfit(int[] prices, int fee) {
    memo = new Integer[prices.length][2];
    return dp(prices, 0, false, fee);
  }

  public int dp(int[] nums, int i, boolean canSell, int fee) {
    int sell = canSell ? 1 : 0;
    if (i == nums.length)
      return 0;

    if (memo[i][sell] != null)
      return memo[i][sell];

    // you can buy it, or you can sell it or you can skip it(tricky).
    int profit = 0;
    if (canSell) {
      profit = Math.max(profit, dp(nums, i + 1, false, fee) + nums[i] - fee);
    } else {
      profit = Math.max(profit, dp(nums, i + 1, true, fee) - nums[i]);
    }

    profit = Math.max(profit, dp(nums, i + 1, canSell, fee));

    return memo[i][sell] = profit;
  }
}

class Main {
  public static void main(String[] args) {
    var res = new Solution().maxProfit(new int[] { 1, 3, 2, 8, 4, 9 }, 2);
    System.out.println(res);
  }
}
