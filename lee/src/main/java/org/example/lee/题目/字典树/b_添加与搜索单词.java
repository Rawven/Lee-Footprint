package org.example.lee.题目.字典树;

public class b_添加与搜索单词 {

  class WordDictionary {

    private Node root;

    public WordDictionary() {
      root = new Node();
    }

    public void addWord(String word) {
      int len = word.length();
      int i = 0;
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
      return search(word, root);
    }

    public boolean search(String word, Node nod) {
      int len = word.length();
      int i = 0;
      Node node = nod;
      while (i < len) {
        char c = word.charAt(i);
        if (c == '.') {
          //遇到 .
          if (i == len - 1) {
            // i == len-1 有字符当终点则可以
            for (int j = 0; j < 26; j++) {
              if (node.next[j] != null && node.next[j].canBeEnd) {
                return true;
              }
            }
            return false;
          }
          //正常遍历递归
          String str = word.substring(i + 1);
          for (int j = 0; j < 26; j++) {
            if (node.next[j] != null && search(str, node.next[j])) {
              return true;
            }
          }
          return false;
        } else if (node.next[c - 'a'] == null) {
          return false;
        }
        node = node.next[c - 'a'];
        i++;
      }
      return node.canBeEnd;
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
