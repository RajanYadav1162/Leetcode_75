/*
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.
 */

class Solution {
  String s1, s2;
  int n1, n2;

  Integer[][] memo;

  public int minDistance(String word1, String word2) {
    s1 = word1;
    s2 = word2;
    n1 = word1.length();
    n2 = word2.length();
    memo = new Integer[n1][n2];

    return dp(0, 0);
  }

  public int dp(int i, int j) {

    if (i == n1 && j == n2)
      return 0;

    // a bit tricky
    if (i == n1) {
      return n2 - j;
    }
    // a bit tricky
    if (j == n2) {
      return n1 - i;
    }

    // if result already in cache
    if (memo[i][j] != null)
      return memo[i][j];

    int ed = Integer.MAX_VALUE;

    // if match
    if (s1.charAt(i) == s2.charAt(j)) {
      ed = Math.min(ed, dp(i + 1, j + 1));
    } else {

      // inserr a char
      ed = Math.min(ed, 1 + dp(i, j + 1));
      // delete a char
      ed = Math.min(ed, 1 + dp(i + 1, j));
      // replace a char
      ed = Math.min(ed, 1 + dp(i + 1, j + 1));
    }

    return memo[i][j] = ed;
  }
}

class Main {
  public static void main(String[] args) {
    var res = new Solution().minDistance("horse", "ros");
    System.out.println(res);
  }
}
