/*
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to
 */

class Node {
  public Node[] children;
  public boolean terminal;

  public Node() {
    children = new Node[26];
  }
}

class Trie {

  Node root;

  public Trie() {
    root = new Node();
  }

  public void insert(String word) {

    Node current = root;
    for (char ch : word.toCharArray()) {
      if (current.children[ch - 'a'] == null) {
        current.children[ch - 'a'] = new Node();
      }

      current = current.children[ch - 'a'];
    }
    current.terminal = true;
  }

  public boolean search(String word) {

    Node current = root;
    for (char ch : word.toCharArray()) {
      if (current.children[ch - 'a'] == null)
        return false;

      current = current.children[ch - 'a'];
    }

    return current.terminal;
  }

  public boolean startsWith(String prefix) {

    Node current = root;
    for (char ch : prefix.toCharArray()) {
      if (current.children[ch - 'a'] == null)
        return false;

      current = current.children[ch - 'a'];
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
