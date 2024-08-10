package org.example.lee.题目.KMP;

public class a_找出字符串中第一个匹配项的下标 {


  /**
   * TODO
   * 生成部分匹配表（next数组），用于KMP算法。
   * 部分匹配表记录了每个字符位置的最长前缀长度。
   *
   * @param s 模式字符串
   * @return 部分匹配表（next数组）
   */
  public static int[] getNext(String s) {
    // j表示前缀的末尾索引，初始值为-1
    int j = -1;
    int[] next = new int[s.length()];
    // next数组初始化，next[0]设为-1
    next[0] = j;

    // 从第二个字符开始，依次计算每个位置的next值
    for (int i = 1; i < s.length(); i++) {
      // 前缀和后缀从左向右看，当前后缀不相等时，回退到前一个位置的next值
      while (j >= 0 && s.charAt(j + 1) != s.charAt(i)) {
        j = next[j];
      }

      // 如果前后缀字符相等，前缀长度加1
      if (s.charAt(j + 1) == s.charAt(i)) {
        j++;
      }

      // 将计算出的前缀长度赋值给next数组
      next[i] = j;
    }

    return next;
  }

  /**
   * 在主字符串haystack中查找子字符串needle的位置。
   *
   * @param haystack 主字符串
   * @param needle   子字符串
   * @return 子字符串在主字符串中的起始位置，如果未找到则返回-1
   */
  public static int strStr(String haystack, String needle) {
    // 如果子字符串为空，返回0
    if (needle.isEmpty()) {
      return 0;
    }

    // 获取子字符串的部分匹配表（next数组）
    int[] next = getNext(needle);
    int j = -1; // j表示子字符串的当前匹配位置

    // 遍历主字符串
    for (int i = 0; i < haystack.length(); i++) {
      // 当主字符串和子字符串的字符不匹配时，回退子字符串的匹配位置
      while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
        j = next[j];
      }

      // 如果主字符串和子字符串的字符匹配，子字符串的匹配位置向前移动
      if (haystack.charAt(i) == needle.charAt(j + 1)) {
        j++;
      }

      // 如果子字符串完全匹配，返回匹配的起始位置
      if (j == needle.length() - 1) {
        return i - needle.length() + 1;
      }
    }

    // 如果未找到匹配，返回-1
    return -1;
  }
}
