/*
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * 
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both
 * strings.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 * 
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 * 
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * 
 * 
 * Constraints:
 * 
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 */

class Solution {
  private String s1, s2;
  private int n1, n2;
  private Integer[][] memo;

  public int longestCommonSubsequence(String s1, String s2) {
    this.s1 = s1;
    this.s2 = s2;
    this.n1 = s1.length();
    this.n2 = s2.length();
    memo = new Integer[n1][n2];
    return dp(0, 0);
  }

  public int dp(int i, int j) {

    // base case is very trivial here, if any of them exhaused we are done!
    if (i == s1.length() || j == s2.length())
      return 0;

    if (memo[i][j] != null)
      return memo[i][j];

    int lcs = 0;

    // if they match, ans lcs will increment by 1, and problem reduces to new
    // subproblem.
    if (s1.charAt(i) == s2.charAt(j)) {
      lcs = Math.max(lcs, 1 + dp(i + 1, j + 1));
    }
    // if not match, try matching next char from s1, and from s2.
    else {
      lcs = Math.max(lcs, dp(i + 1, j));
      lcs = Math.max(lcs, dp(i, j + 1));
    }

    return memo[i][j] = lcs;
  }
}
