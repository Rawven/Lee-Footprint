package org.example.lee.题目.字符串;

public class a_重复的子字符串 {


  public  boolean repeatedSubstringPattern(String s) {
    if (s.isEmpty()) {
      return false;
    }
    int len = s.length(), j = -1;
    int[] next = new int[len];
    next[0] = j;
    for (int i = 1; i < s.length(); i++) {
      while (j >= 0 && s.charAt(j + 1) != s.charAt(i)) {
        j = next[j];
      }
      if (s.charAt(j + 1) == s.charAt(i)) {
        j++;
      }
      next[i] = j;
    }

    return next[len - 1] >= 0 && len % (len - (next[len - 1] + 1)) == 0;
  }
}
