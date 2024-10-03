/*
 * You are given two positive integer arrays spells and potions, of length n and
 * m respectively, where spells[i] represents the strength of the ith spell and
 * potions[j] represents the strength of the jth potion.
 * 
 * You are also given an integer success. A spell and potion pair is considered
 * successful if the product of their strengths is at least success.
 * 
 * Return an integer array pairs of length n where pairs[i] is the number of
 * potions that will form a successful pair with the ith spell.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
 * Output: [4,0,3]
 * Explanation:
 * - 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
 * - 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
 * - 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
 * Thus, [4,0,3] is returned.
 * Example 2:
 * 
 * Input: spells = [3,1,2], potions = [8,5,8], success = 16
 * Output: [2,0,2]
 * Explanation:
 * - 0th spell: 3 * [8,5,8] = [24,15,24]. 2 pairs are successful.
 * - 1st spell: 1 * [8,5,8] = [8,5,8]. 0 pairs are successful.
 * - 2nd spell: 2 * [8,5,8] = [16,10,16]. 2 pairs are successful.
 * Thus, [2,0,2] is returned.
 * 
 * 
 * Constraints:
 * 
 * n == spells.length
 * m == potions.length
 * 1 <= n, m <= 105
 * 1 <= spells[i], potions[i] <= 105
 * 1 <= success <= 1010
 */

//Solution

/*
 * Main idea is for every S[i], we have to found out how many P[j] are there where S[i] * P[i] >= s.
   so if we somehow sort the P array, and find out which is the first postion where S[i] * P[i] >= s, next position elements will automatically satisfied the condition since P array is sorted.
 */
class Solution {
  public int[] successfulPairs(int[] S, int[] P, long s) {
    Arrays.sort(P);
    int m = S.length, n = P.length;
    int[] ans = new int[m];
    for (int i = 0; i < m; i++) {
      ans[i] = binarySearch(P, s, S[i]);
    }
    return ans;
  }

  public int binarySearch(int[] P, long s, int t) {
    int left = 0, right = P.length;

    while (left < right) {
      int mid = left + (right - left) / 2;

      // let say we have P = [1, 2, 3, 4, 5, 6, 7], t = 3 ans s = 6. then at 1th
      // position 3 * 2 >= 6.so our binary search in term of
      // monotonicity will look like [F, T, T, T, T, T, T], left will return the very
      // first T index.
      if (1L * t * P[mid] >= s) {
        right = mid;
      } else
        left = mid + 1;
    }

    // we are not able to find any element in P, where multiplication gives >= s.
    if (left == P.length)
      return 0;

    // if [1, 2, 3, 4, 5, 6], if get left =3-->4, automatically 5, 6 will be
    // satisfied.
    return P.length - left;

  }
}
