/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

    A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

    Example 1:

    Input: s = "abc", t = "ahbgdc"
    Output: true
    Example 2:

    Input: s = "axc", t = "ahbgdc"
    Output: false


*/

//solution idea
/*
  1. create two pointers started at 0 index for both s and t.
  2. when we found a match, we increment both
  3. if we don't found a match, meaning we are not able to take the current character from s1 as subsequence so we try to find it
     by incrementing the jth Index.
 */


class Solution {

  public boolean isSubsequence(String s, String t) {

    int i = 0, j = 0;
    int n1 = s.length(), n2 = t.length();

    while (i < n1 && j < n2) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
        j++;
      } else {
        j++;
      }
    }

    return i == n1;
  }
}
