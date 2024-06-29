package org.example.lee.题目.其它;

public class b_字符串相乘 {

  public static void main(String[] args) {
    multiply("2", "3");
  }

  /**
   * 优化竖式  3ms 主要利用 i*j 位于的位置是 i+j与i+j+1
   *
   * @param num1 num1
   * @param num2 num2
   * @return {@link String}
   */
  public static String multiply(String num1, String num2) {
    int len = num2.length() + num1.length(), len1 = num1.length(), len2 = num2.length();
    int[] arr = new int[len];
    int tool = '0';
    if ((len1 == 1 && num1.charAt(0) == '0') || (len2 == 1 && num2.charAt(0) == '0')) {
      return "0";
    }
    for (int i = len1 - 1; i >= 0; i--) {
      for (int j = len2 - 1; j >= 0; j--) {
        int rs = (num1.charAt(i) - tool) * (num2.charAt(j) - tool);
        arr[i + j + 1] += rs;
        arr[i + j] += arr[i + j + 1] / 10;
        arr[i + j + 1] = arr[i + j + 1] % 10;
      }
    }
    StringBuilder sb = new StringBuilder();
    if (arr[0] != 0) {
      sb.append((char) (arr[0] + '0'));
    }
    for (int j = 1; j < len; j++) {
      sb.append((char) (arr[j] + '0'));
    }
    return sb.toString();
  }


  /**
   * 蔗民版 11ms multiply1
   *
   * @param num1 num1
   * @param num2 num2
   * @return {@link String}
   */
  public String multiply1(String num1, String num2) {
    int len = num2.length() + num1.length(), len1 = num1.length(), len2 = num2.length();
    int[] arr = new int[len];
    int tool = '0';
    if ((num1.length() == 1 && num1.charAt(0) == '0') || (num2.length() == 1
        && num2.charAt(0) == '0')) {
      return "0";
    }
    for (int i = len1 - 1; i >= 0; i--) {
      for (int j = len2 - 1; j >= 0; j--) {
        int rs = (num1.charAt(i) - tool) * (num2.charAt(j) - tool);
        arr[i + j] += rs % 10;
        if (arr[i + j] >= 10) {
          arr[i + j + 1] += arr[i + j] / 10;
          arr[i + j] = arr[i + j] % 10;
        }
        arr[i + j + 1] += rs / 10;
      }
    }
    StringBuilder sb = new StringBuilder();
    if (arr[0] != 0) {
      sb.append((char) (arr[0] + '0'));
    }
    for (int j = 1; j < len; j++) {
      sb.append((char) (arr[j] + '0'));
    }
    return sb.toString();
  }

  public String addStrings(String num1, String num2) {
    int len1 = num1.length(), len2 = num2.length();
    int tool = '0', tool2 = 0, save = 0;
    StringBuilder sb = new StringBuilder();
    while (len1 > 0 || len2 > 0 || save > 0) {
      if (len1 > 0) {
        tool2 += (num1.charAt(len1 - 1) - tool);
        len1--;
      }
      if (len2 > 0) {
        tool2 += (num2.charAt(len2 - 1) - tool);
        len2--;
      }
      tool2 += save;
      sb.append((char) (tool2 % 10 + '0'));
      save = tool2 / 10;
      tool2 = 0;
    }
    return sb.reverse().toString();
  }
}
