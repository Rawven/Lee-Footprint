package org.example.lee.题目.双指针;

public class a_验证回文串 {

  public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }
      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  /**
   * is palindrome 不使用api
   *
   * @param s s
   * @return boolean
   */
  public boolean isPalindrome1(String s) {
    int left = 0, right = s.length() - 1;
    char a, b;
    while (left < right) {
      a = 0;
      b = 0;
      while (left <= right) {
        char c = s.charAt(left);
        if (check(c)) {
          a = c;
          left++;
          break;
        } else if (c >= 'A' && c <= 'Z') {
          a = (char) (c + 32);
          left++;
          break;
        }
        left++;
      }
      while (left <= right) {
        char c = s.charAt(right);
        if (check(c)) {
          b = c;
          right--;
          break;
        } else if (c >= 'A' && c <= 'Z') {
          b = (char) (c + 32);
          right--;
          break;
        }
        right--;
      }
      if (left - 1 == right) {
        return a == b || b == 0;
      }
      if (a != b) {
        return false;
      }
    }
    return true;
  }

  boolean check(char c) {
    return (c >= 'a' && c <= 'z') ||
        (c >= '0' && c <= '9');
  }
}
