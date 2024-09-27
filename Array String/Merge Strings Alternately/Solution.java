/*

You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
starting with word1. If a string is longer than the other, append the additional letters onto the end
of the merged string. Return the merged string.

    Example 1:

    Input: word1 = "abc", word2 = "pqr"
    Output: "apbqcr"
    Explanation: The merged string will be merged as so:
    word1:  a   b   c
    word2:    p   q   r
    merged: a p b q c r

*/

class Solution {

  public String mergeAlternately(String s1, String s2) {

    int i = 0, j = 0, n1 = s1.length(), n2 = s2.length();

    // String in java is immutable, so string concatation will cause extra String
    // creation. to avoid use StringBuilder.
    StringBuilder sb = new StringBuilder();

    // if flag == 0, pick from s1 other wise pick from s2.so first choose from s1,
    // use it, and change the flag = 1, so next time it chooses s2.
    int flag = 0;

    while (i < n1 && j < n2) {
      if (flag == 0) {
        sb.append(s1.charAt(i));
        i++;
        flag = 1;
      } else {
        sb.append(s2.charAt(j));
        j++;
        flag = 0;
      }
    }

    // after above operation, if s1 and s2 are of different length, we have to add
    // the extra character from either s1 or s2.eg. s1 = "abc", s2="d" then "ad"
    // will be on our StringBuilder, now i haven't reaches its end we have to append
    // remaining characters from s1.(& vice-versa)

    // j migh have exhausted.(s1 = "abcd", s2="cd")
    while (i < n1) {
      sb.append(s1.charAt(i));
      i++;
    }

    // i might have exhaused(s1 = "a", s2="defs")
    while (j < n2) {
      sb.append(s2.charAt(j));
      j++;
    }

    return sb.toString();

  }
}

class Main {

  public static void main(String[] args) {

    var res = new Solution().mergeAlternately("abc", "pqr");

    System.out.println(res);
  }
}