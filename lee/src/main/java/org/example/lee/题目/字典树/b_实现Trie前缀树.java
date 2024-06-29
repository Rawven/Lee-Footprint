package org.example.lee.题目.字典树;

public class b_实现Trie前缀树 {

  class Trie {

    public Node root;

    public Trie() {
      root = new Node();
    }

    public void insert(String word) {
      int len = word.length(), i = 0;
      Node node = root;
      while (i < len) {
        char c = word.charAt(i);
        if (node.next[c - 'a'] == null) {
          node.next[c - 'a'] = new Node();
        }
        node = node.next[c - 'a'];
        i++;
      }
      node.canBeEnd = true;
    }

    public boolean search(String word) {
      Node tool = tool(word);
      if (tool != null) {
        return tool.canBeEnd;
      }
      return false;
    }

    public boolean startsWith(String prefix) {
      Node tool = tool(prefix);
      return tool != null;
    }

    private Node tool(String str) {
      int len = str.length(), i = 0;
      Node node = root;
      while (i < len) {
        char c = str.charAt(i);
        if (node.next[c - 'a'] == null) {
          return null;
        }
        node = node.next[c - 'a'];
        i++;
      }
      return node;
    }

    class Node {

      public Node[] next;
      public boolean canBeEnd;

      public Node() {
        next = new Node[26];
      }
    }
  }

}
