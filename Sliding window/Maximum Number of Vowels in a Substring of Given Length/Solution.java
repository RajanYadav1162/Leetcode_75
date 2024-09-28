/*
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 */

//Solution
/*
1. Typical fixed size sliding window problem.
2. if we see a problem asking for something on a fixed length substring, this technique is very useful;
 */

class Solution {

  public int maxVowels(String s, int k) {

    //inital window manual calculation is required on such type of problem.
    int count = 0, ans = 0;
    for (int i = 0; i < k; i++) {
      if (isVowel(s.charAt(i))) {
        count++;
      }
    }
    ans = count;
    int n = s.length();

    //after initial calculation is done, we just need to update it according to window, eg, remove from start, add from end.
    for (int i = 0, j = k; j < n; j++, i++) {
      if (isVowel(s.charAt(i))) {
        count--;
      }
      if (isVowel(s.charAt(j))) {
        count++;
      }

      ans = Math.max(ans, count);
    }

    return ans;
  }

  private boolean isVowel(char ch) {
    return ch == 'a' || ch == 'o' || ch == 'i' || ch == 'o' || ch == 'u';
  }
}
