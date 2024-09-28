
import java.util.*;

/*
Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 */

//Solution
/*
1. just keep track of frequency of a number in the array
2. check once, is there any duplicated frequency are there or not using Set data structure.
 */

class Solution {

  public boolean uniqueOccurrences(int[] arr) {

    var set = new HashSet<Integer>();
    //we can use Map too, but since values are limited we can use array for tracking freq of a number.
    //since number can be negative we add an offset of 1000, so for -1000 its index is 0;...and so on
    int[] freq = new int[20001];

    for (int a : arr) {
      freq[a + 1000] += 1;
    }

    for (int f : freq) {
      if (f == 0) {
        continue;
      }
      if (set.contains(f)) {
        return false;
      }
      set.add(f);
    }

    return true;
  }
}
