/*
 * You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. You must choose a subsequence of indices from nums1 of length k.

For chosen indices i0, i1, ..., ik - 1, your score is defined as:

The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
Return the maximum possible score.

A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.
 */

class Solution {
  public long maxScore(int[] A, int[] B, int k) {

    long ans = 0;

    List<int[]> list = new ArrayList<>();

    for (int i = 0; i < A.length; i++) {
      list.add(new int[] { A[i], B[i] });
    }

    // benfit of such sorting is, when we are iterating we always going to have
    // min(B) in access.we just need to handle the sum part.
    list.sort((a, b) -> Integer.compare(b[1], a[1]));

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    long cs = 0;
    for (var item : list) {
      cs += item[0];
      pq.offer(item[0]);

      if (pq.size() == k) {
        ans = Math.max(ans, cs * 1L * item[1]);
        // after calculation, for the next time pq.offer will make pq size > k, so lets
        // handle right now.
        var temp = pq.poll();
        cs -= temp;
      }
    }
    return ans;
  }
}
