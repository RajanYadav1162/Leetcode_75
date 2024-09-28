
/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.



Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */

//Solution
/*
1. when we say we can flip max k number of zero to 1, this simply means, in a valid window we can take max k zeros.
2. so we keep maintaining a window, if it exceeds k number of zeros, we shrink it.
3. typical variable size sliding window problem.
 */

class Solution {

  public int longestOnes(int[] nums, int k) {

    int ans = 0;

//    czc--> current zero count in a particular window
    int left = 0, right = 0, n = nums.length, czc = 0;

    while (right < n) {
      if (nums[right] == 0) {
        czc++;
      }

      //if in current window, we got more zeros then k, we have to shrink it, meaning increase left pointer, do the necessary changes.
      while (left < n && czc > k) {
        if (nums[left] == 0) {
          czc--;
        }
        left++;
      }

      //here we always have a valid window, so can try maximising the answer.
      ans = Math.max(ans, right - left + 1);

      right++;
    }

    return ans;
  }
}
