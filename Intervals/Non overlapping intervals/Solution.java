
/*
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 
 Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
 
  
 
 Example 1:
 
 Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 Output: 1
 Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 Example 2:
 
 Input: intervals = [[1,2],[1,2],[1,2]]
 Output: 2
 Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 Example 3:
 */
import java.util.*;

class Solution {
  public int eraseOverlapIntervals(int[][] A) {

    Arrays.sort(A, Comparator.comparingInt(a -> a[0]));

    int count = 0;
    int ce = A[0][1];

    for (int i = 1; i < A.length; i++) {

      // if non overlapped, we have to take extrme end one which is alwasy going to be
      // A[i][1]
      // why? becuase start of A[i][0] is always greater then or equals to CE.
      if (A[i][0] >= ce) {

      } else {
        count++;
        ce = Math.min(ce, A[i][1]);
      }
    }

    return count;
  }
}
