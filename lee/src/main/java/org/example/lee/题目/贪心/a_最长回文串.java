package org.example.lee.题目.贪心;

public class a_最长回文串 {

  public int longestPalindrome(String s) {
    if (s.isEmpty()) {
      return 0;
    }
    int key = 0;
    int[] ints = new int[123];
    for (int i = 0; i < s.length(); i++) {
      ints[s.charAt(i)]++;
      if (ints[s.charAt(i)] % 2 == 0) {
        key += 2;
      }
    }
    if (s.length() - key > 0) {
      key++;
    }
    return key;
  }
}
