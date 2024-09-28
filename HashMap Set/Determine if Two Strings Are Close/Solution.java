
/*
Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.



Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"
Example 2:

Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
Example 3:
 */

//Solution
/*
1. we have to understand such type of infinite operation question in different way.
2. operation 1 - we can swap any two characters, meaning order of s1 and s2 doesn't matter
3. operation 2 - since we can transform one character to other EXISTING one, we need to just make frequency of characters from s1
   should match with all the frequency of s2, and s1 should contain all character from s2.
 */

class Solution {

  public boolean closeStrings(String s1, String s2) {

    Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();

    //keep track of freq of characters from s1.
    for (char ch : s1.toCharArray()) {
      map1.merge(ch, 1, Integer::sum);
    }

    //keep track of freq of characters from s2.
    for (char ch : s2.toCharArray()) {
      map2.merge(ch, 1, Integer::sum);
    }

    //if size not equal, we can never attain one from another based on our operation
    if (map1.size() != map2.size()) {
      return false;
    }

    //here we are checking all the characters from s1 should be in s2.
    for (var k : map1.keySet()) {
      if (!map2.containsKey(k)) {
        return false;
      }
    }

    //the check frequency of all the characters from s1 and s2.
    var l = map1.values();
    var r = map2.values();

    return l.stream().sorted().collect(Collectors.toList()).equals(r.stream().sorted().collect(
        Collectors.toList()));

  }
}
