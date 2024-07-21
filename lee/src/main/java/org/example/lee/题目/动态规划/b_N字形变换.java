package org.example.lee.题目.动态规划;

public class b_N字形变换 {


  public String convert(String s, int numRows) {
    int round = numRows * 2 - 2, len = s.length();
    StringBuilder stringBuilder = new StringBuilder();
    int index = 0, save;
    while (index < numRows) {
      save = index;
      while (save < len) {
        stringBuilder.append(s.charAt(save));
        if (index != 0 && index != numRows - 1) {
          int check = save + round - 2 * (save % round);
          if (check < len) {
            stringBuilder.append(s.charAt(check));
          }
        }
        save += round;
      }
      index++;
    }
    return stringBuilder.toString();
  }
}
