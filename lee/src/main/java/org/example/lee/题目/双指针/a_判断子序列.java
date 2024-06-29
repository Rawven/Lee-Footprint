package org.example.lee.题目.双指针;

public class a_判断子序列 {

  /**
   * is subsequence 双指针版
   *
   * @param s s
   * @param t t
   * @return boolean
   */
  public boolean isSubsequenceS(String s, String t) {
    int a = 0, b = 0, len1 = t.length(), len2 = s.length();
    while (a < len1 && b < len2) {
      if (t.charAt(a) == s.charAt(b)) {
        b++;
      }
      a++;
    }
    return b == len2;
  }

  /**
   * is subsequenced dp版 主要思想就是 用一个数组存一个可以指向下一个字母的下标，这样可以有一个预处理的数组 使得如果有多个s想知道是不是t的子串，就会节省一点时间
   *
   * @param s s
   * @param t t
   * @return boolean
   */
  public boolean isSubsequenceD(String s, String t) {
    int len1 = t.length(), len2 = s.length();
    int[][] dp = new int[len1 + 1][26];
    //标记
    for (int i = 0; i < 26; i++) {
      dp[len1][i] = -1;
    }
    //预处理数组
    for (int i = len1 - 1; i >= 0; i--) {
      for (int j = 0; j < 26; j++) {
        if (t.charAt(i) == j + 'a') {
          dp[i][j] = i;
        } else {
          dp[i][j] = dp[i + 1][j];
        }
      }
    }
    //这里开始正常处理判断是不是子串
    int a = 0;
    for (int i = 0; i < len2; i++) {
      if (dp[a][s.charAt(i) - 'a'] == -1) {
        return false;
      }
      a = dp[a][s.charAt(i) - 'a'] + 1;
    }
    return true;
  }

}
