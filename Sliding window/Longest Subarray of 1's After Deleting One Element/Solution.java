/*
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.



Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
 */

//Solution
/*
1.Similar to previous problem of number of consecutive ones -3.
2. here by default k = 1.
3. see the comment on line 50.
 */

class Solution {

  public int longestSubarray(int[] nums) {

    int ans = 0;
    int k = 1;

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
      //since we always goint to delete 1 element max, either there will be 1 zero, or no zero.
      //because in our window we can have max one zero.
      ans = Math.max(ans, right - left);
      right++;
    }

    return ans;
  }
}
