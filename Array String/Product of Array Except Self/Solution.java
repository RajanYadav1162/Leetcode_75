/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */

//Solution
/*
  1. this is typical prefix and suffix algo based problem, hard to come up by yourself.
  2. we are going to maintain prefix product and suffix product for each position
  3. then if you carefully analyze, you will find out ans[i] = prefix[i] * suffix[i].
  4. again we can optimize the solution with constant space.
 */

class Solution {

  public int[] productExceptSelf(int[] nums) {

    int n = nums.length;

    int[] ans = new int[n];

    int product = 1;

    //in this part ans is carrying prefix product.
    for (int i = 0; i < n; i++) {
      ans[i] = product;
      product *= nums[i];
    }

    product = 1;

    //since we already have prefix product in the answer, we are gonna calculate suffix product on the fly, and use it
    //with prefix product.
    for (int i = n - 1; i >= 0; i--) {
      ans[i] *= product;
      product *= nums[i];
    }

    return ans;
  }
}
