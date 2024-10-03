/*
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has
 * piles[i] bananas. The guards have gone and will come back in h hours.
 * 
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she
 * chooses some pile of bananas and eats k bananas from that pile. If the pile
 * has less than k bananas, she eats all of them instead and will not eat any
 * more bananas during this hour.
 * 
 * Koko likes to eat slowly but still wants to finish eating all the bananas
 * before the guards return.
 * 
 * Return the minimum integer k such that she can eat all the bananas within h
 * hours.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * Example 2:
 * 
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * Example 3:
 * 
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 * 
 * 
 * Constraints:
 * 
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 */

//Solution
/*
 * 1. typical binary search on answer based question.
   2. we choose some speek k, and they check is this a good enough speed for kooku to eat the bananas.
      if yes, try reducing the speed, else increase the speed.
 */

class Solution {
  public int minEatingSpeed(int[] nums, int h) {

    int left = 0, right = Arrays.stream(nums).max().getAsInt();

    while (left < right) {
      int mid = left + (right - left) / 2;

      // meaning mid is good enough speed for kooku, try minimising more to get more
      // less speed.
      if (good(nums, h, mid)) {
        right = mid;
      } else
        left = mid + 1;
    }

    return left;
  }

  public boolean good(int[] nums, int h, int k) {
    int req = 0;
    for (int a : nums) {
      // a*1.0/k, -->*1.0 to make whole equation produce double value, then we can
      // simply take ceiling( Q + 1(if its not divisible))
      req += (int) Math.ceil(a * 1.0 / k);
      // still some bananas left, but guard comes.
      if (req > h)
        return false;
    }

    return true;
  }
}
