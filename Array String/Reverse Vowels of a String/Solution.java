
/*
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"
 */

//Solution IDEA
/*
 * This question is based on reversing an array using two pointers. like let say we wanted to reverse the array[1, 2, 3, 4].
 * we put one pointer at 1 and another pointer at 4, we reverse it, increase left pointer and decrease right pointer.
 * we'll keep doing it, until i<j.
 * We have to apply the same logic, just make sure that we are only going to swap when both side is vowel.
 * */

class Solution {

  public String reverseVowels(String s) {

    char[] ch = s.toCharArray();

    int i = 0, j = s.length() - 1;

    while (i < j) {
      //if both, left and right sides values are vowels, swap it.
      if (isV(ch[i]) && isV(ch[j])) {
        reverse(ch, i, j);
        i++;
        j--;
        //if left side is not vowel, increase left pointer
      } else if (!isV(ch[i])) {
        i++;

        //if right side is not vowel, decrease right pointer.
      } else {
        j--;
      }
    }

    return String.valueOf(ch);
  }

  private void reverse(char[] ch, int i, int j) {
    char temp = ch[i];
    ch[i] = ch[j];
    ch[j] = temp;
  }

  private boolean isV(char ch) {

    //since vowel can be a or A, e or E.......just convert to lower case for simplicity.
    ch = Character.toLowerCase(ch);
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
  }
}
