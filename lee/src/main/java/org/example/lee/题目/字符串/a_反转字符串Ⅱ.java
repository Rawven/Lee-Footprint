package org.example.lee.题目.字符串;

public class a_反转字符串Ⅱ {


  public String reverseStr(String s, int k) {
    int index = 0;
    char[] array = s.toCharArray();
    while (index <= s.length()) {
      if (s.length() - index >= 2 * k) {
        reverseStr(array, index, index + k - 1);
        index += 2 * k;
      } else if (s.length() - index < k) {
        reverseStr(array, index, s.length() - 1);
        break;
      } else if (s.length() - index < 2 * k) {
        reverseStr(array, index, index + k - 1);
        break;
      }
    }
    return new String(array);
  }

  private void reverseStr(char[] s, int start, int end) {
    int left = start, right = end;
    char h;
    while (left <= right) {
      h = s[left];
      s[left] = s[right];
      s[right] = h;
      left++;
      right--;
    }
  }
}
