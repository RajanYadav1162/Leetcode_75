/*
For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t
(i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.



Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
* */


//Solution Idea
/*
  1. first we need to figure out when its not possible to find answer., if we dry run some examples we find out that
  only when (s1+ s2) == (s2+s1), then only the answer is possible.

  2. after validating the above steps, we just need to find gcd(a, b) where a is len(a) and b is len(b).
  3. basically find largest number that can divide both the strings.
 */
class Solution {

  public String gcdOfStrings(String s1, String s2) {

    //first check is this possible to find a string that divides both.?
    if (!((s1 + s2).equals(s2 + s1))) {
      return "";
    }

    //if we reach here, there is potential answer available for this.
    int a = s1.length(), b = s2.length();
    int gcd = gcd(a, b);
    return s1.substring(0, gcd);
  }

  public int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
