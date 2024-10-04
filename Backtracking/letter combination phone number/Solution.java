import java.util.*;

/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

//solved using both approach using normal recursion with global and non global.

class Solution1 {
  private static final String[] map = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
  private final static int offset = 2;
  List<String> ans = new ArrayList<>();

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0)
      return ans;

    dfs(digits, 0, "");
    return ans;
  }

  public void dfs(String s, int i, String psf) {

    if (i == s.length()) {
      ans.add(psf);
      return;
    }

    // if s = 23, we are at 2, the recur, a, and b, and c.
    for (var ch : map[Integer.parseInt(s.charAt(i) + "") - offset].toCharArray()) {
      dfs(s, i + 1, psf + ch);
    }
  }
}

class Solution {
  private static final String[] map = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
  private final static int offset = 2;
  List<String> ans = new ArrayList<>();

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0)
      return ans;

    return dfs(digits, 0);

  }

  public List<String> dfs(String s, int i) {

    if (i == s.length())
      return new ArrayList<>(Arrays.asList(""));

    String temp = map[Integer.parseInt(s.charAt(i) + "") - offset];

    var partial = dfs(s, i + 1);
    // for s = 23, think of this like we already get result for 3, [d, e, f] and we
    // need to append based on 2.
    List<String> ans = new ArrayList<>();
    for (char ch : temp.toCharArray()) {
      for (var p : partial) {
        ans.add(ch + p);
      }
    }
    return ans;

  }

}

class Main {
  public static void main(String[] args) {
    var res = new Solution().letterCombinations("23");
    System.out.println(res);
  }
}
