package org.example.lee.题目.字符串;

public class a_最后一个单词的长度 {


  /**
   * length of last word 倒向直接查
   *
   * @param s s
   * @return int
   */
  public int lengthOfLastWord(String s) {
    int len = s.length(), index = len - 1, key = 0;
    while (index >= 0 && s.charAt(index) == ' ') {
      index--;
    }
    while (index >= 0 && s.charAt(index) != ' ') {
      key++;
      index--;
    }
    return key;
  }

  /**
   * length of last word 正向蠢死了
   *
   * @param s s
   * @return int
   */
  public int lengthOfLastWord1(String s) {
    int len = s.length(), index = 0, key = 0, save = 0;
    while (index < len) {
      char c = s.charAt(index);
      if (c != ' ') {
        save++;
      } else if (index - 1 >= 0 && s.charAt(index - 1) != ' ') {
        key = save;
        save = 0;
      }
      index++;
    }
    return save == 0 ? key : save;
  }
}
