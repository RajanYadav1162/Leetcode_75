
import java.util.Arrays;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]

 */


//Solution
/*
1. typical two pointer problem.
2. we are going to maintain a left pointer, initially at 0 index, it will keep track of last non-zero element.
3. if we find non-zero element, we are going to swap it.
 */
class Solution {

  public void moveZeroes(int[] nums) {

    int left = 0;

    for (int i = 0; i < nums.length; i++) {
      int a = nums[i];
      if (a != 0) {
        swap(nums, left, i);
        left++;
      }
    }
  }

  private void swap(int[] A, int left, int right) {
    int temp = A[left];
    A[left] = A[right];
    A[right] = temp;
  }
}
