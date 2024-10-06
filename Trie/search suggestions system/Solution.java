import java.util.*;

/*
 * You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.


Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Explanation: The only word "havana" will be always suggested while typing the search word.
 */

class Solution {
  public List<List<String>> suggestedProducts(String[] P, String W) {
    List<List<String>> ans = new ArrayList<>();
    Arrays.sort(P);
    Trie trie = new Trie();
    for (var p : P)
      trie.insert(p);

    StringBuilder sb = new StringBuilder();
    for (var w : W.toCharArray()) {
      sb.append(w);
      var list = suggestion(trie.root, sb.toString());
      Collections.addAll(ans, list);
      // System.out.println("for prefix " + sb + " " + list);
    }

    return ans;
  }

  public List<String> suggestion(Node root, String prefix) {
    List<String> list = new ArrayList<>();
    for (char ch : prefix.toCharArray()) {
      if (root.children[ch - 'a'] == null)
        return list;
      root = root.children[ch - 'a'];
    }

    generate(root, list, prefix);
    return list;
  }

  public void generate(Node node, List<String> list, String psf) {

    if (list.size() == 3)
      return;

    if (node.terminal)
      list.add(psf);

    for (char i = 'a'; i <= 'z'; i++) {
      if (node.children[i - 'a'] != null) {
        generate(node.children[i - 'a'], list, psf + i);
      }
    }
  }
}

class Node {
  public Node[] children = new Node[26];
  public boolean terminal = false;
}

class Trie {
  Node root;

  public Trie() {
    root = new Node();
  }

  public void insert(String s) {
    Node current = root;
    for (char ch : s.toCharArray()) {
      if (current.children[ch - 'a'] == null) {
        current.children[ch - 'a'] = new Node();
      }

      current = current.children[ch - 'a'];
    }
    current.terminal = true;
  }
}

class Main {
  public static void main(String[] args) {

    var res = new Solution().suggestedProducts(new String[] { "mobile", "mouse", "moneypot", "monitor", "mousepad" },
        "mouse");
    System.out.println(res);
  }
}
