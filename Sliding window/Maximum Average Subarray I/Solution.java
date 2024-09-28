
/*
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
Any answer with a calculation error less than 10-5 will be accepted.

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
 */

//Solution

/*
1. this if fixed size slide window problem
2. we have to keep track of updated values when moving both left and right pointer.
 */
class Solution {

  public double findMaxAverage(int[] nums, int k) {

    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    int n = nums.length;
    double ans = (sum * 1.0) / k;

    for (int i = 0, j = k; j < n; i++, j++) {

      //[1, 2, 3, 4, 5], lets say k = 2, i = 0, j = 1, when we move to next window, [2, 3], we need to subtract 1 and add 3.
      sum -= nums[i];
      sum += nums[j];
      ans = Math.max(ans, (sum * 1.0) / k);
    }
    return ans;
  }
}
