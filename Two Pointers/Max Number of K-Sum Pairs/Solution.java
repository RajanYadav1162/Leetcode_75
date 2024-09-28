import java.util.Arrays;


/*
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
 */

//Solution
/*
1. We can solve this using hashmap too using logic of two sum.
2. first sort it, and then try to find a sum which is equals to k, if found, adjust both the pointers.
3. otherwise try to make sum == k, by changing left and right pointer
 */

class Solution {

  public int maxOperations(int[] nums, int k) {

    int count = 0;
    Arrays.sort(nums);

    int i = 0, j = nums.length - 1;
    while (i < j) {
      int sum = nums[i] + nums[j];

      //we found sum == k, increase the count.
      if (sum == k) {
        count++;
        i++;
        j--;

      }
      //sum is less than K, meaning we have to increase left pointer which will make next sum is bigger(since array is sorted)
      else if (sum < k) {
        i++;
      } else {
        j--;
      }
    }

    return count;
  }
}
