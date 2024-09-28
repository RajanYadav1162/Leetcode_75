

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words.
The returned string should only have a single space separating the words. Do not include any extra spaces.



Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
 */

//solution
/*
 1. In java, trim() method will remove whitespaces from front and back.
 2. after removing that, we can split the string based on one or more whitespaces.
 3. then its become trivial problem
 */

class Solution {

  public String reverseWords(String s) {

    s = s.trim();
    String[] words = s.split("\\s+");
    reverse(words);
    return String.join(" ", words);
  }

  private void reverse(String[] A) {

    int i = 0, j = A.length - 1;
    while (i < j) {
      String temp = A[i];
      A[i] = A[j];
      A[j] = temp;
      i++;
      j--;
    }
  }
}

