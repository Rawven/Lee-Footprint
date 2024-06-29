package org.example.lee.题目.其它;

public class b_最长回文子串 {

  /**
   * 给你一个字符串 s，找到 s 中最长的回文子串。 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 longest palindrome
   * <p>
   * 使用中心扩散法 复杂度 n²
   *
   * @param s s
   * @return {@link String}
   */
  public String longestPalindrome(String s) {
    //进行特殊情况的处理
    int maxLen = 1, maxHead = 0;
    //直接枚举每个对称中点的位置
    for (int i = 0; i < s.length(); i++) {
      // baab情况
      int l = i - 1, r = i;
      while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
        if (maxLen < r - l + 1) {
          maxHead = l;
          maxLen = r - l + 1;
        }
        l--;
        r++;
      }
      //bab情况
      l = i - 1;
      r = i + 1;
      while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
        if (maxLen < r - l + 1) {
          maxHead = l;
          maxLen = r - l + 1;
        }
        l--;
        r++;
      }
    }
    return s.substring(maxHead, maxHead + maxLen);
  }
}
