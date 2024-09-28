
import java.util.Arrays;
/*
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.



Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
Example 2:
 */

//Solution idea
/*

  1. first find all the streak of same characters maintaining left and right index of it.(generally we do in sliding window)
  2. then depending on streak, do as questions says.
 */


class Solution {

  public int compress(char[] chars) {

    int left = 0, right = 0, k = 0;
    int n = chars.length;

    while (right < n) {

      int count = 0;

      //finding the consecutive characters that are same.
      while (right < n && chars[left] == chars[right]) {
        count++;
        right++;
      }

      //we need to set chars[left] explicitly because, [a, a, a, a,a , b, b, b]-->[a, 5, "at this position we need mark it as new chars[left]"
      chars[k++] = chars[left];

      //not if count is 1, ignore, otherwise if its let say 123, we have to write it as 1-->2--->3.
      if (count > 1) {
        String s = String.valueOf(count);
        for (int i = 0; i < s.length(); i++) {
          chars[k++] = s.charAt(i);
        }
      }
      //chars[left] != chars[rigjt] this is always going to be the case, just check for right out of bound condition.
      if (right < n && chars[left] != chars[right]) {
        left = right;
      }
    }

    return k;
  }
}
