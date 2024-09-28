/*Given an integer array nums, return true if there exists a triple of indices (i, j, k)
such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3,
 */

//Solution idea
/*
  1. In such type of triplet based questions, we generally focus on one pointer, and then try to find the other two pointer.
  2. here we will focus on 'j', and then try to find 'i' and 'k' to satisfy the conditions.
  3. Idea is, at every index, we are gonna keep what's the lowest value before this index and what's the largest value after this index.
 */

class Solution {

  private static final int pinf = Integer.MAX_VALUE, ninf = Integer.MIN_VALUE;

  public boolean increasingTriplet(int[] nums) {

    int n = nums.length;

    //LM[i] =  represent min values from nums[0]----nums[i-1]
    //RM[i] =  represent max values from nums[i+1] ......nums[n-1]
    int[] LM = new int[n], RM = new int[n];

    int max = pinf;
    for (int i = 0; i < n; i++) {
      LM[i] = max;
      max = Math.min(max, nums[i]);
    }

    max = ninf;
    for (int j = n - 1; j >= 0; j--) {
      RM[j] = max;
      max = Math.max(max, nums[j]);
    }

    for (int j = 1; j < n - 1; j++) {
      // for every 'j', we are trying to find a potential answer, eg. is there any value in left of nums[j] and is there any value
      // in the right that's larger than nums[j]
      if (LM[j] < nums[j] && RM[j] > nums[j]) {
        return true;
      }
    }

    return false;
  }
}
