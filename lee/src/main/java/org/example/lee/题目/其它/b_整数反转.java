package org.example.lee.题目.其它;

public class b_整数反转 {

  /**
   * 给你一个 32 位的有符号整数 x ，返 回将 x 中的数字部分反转后的结果。 reverse
   * <p>
   * 主要问题在于如何处理溢出情况 直接对比/10后是否相等
   *
   * @param x x
   * @return int
   */
  public static int reverse(int x) {
    int i;
    int answer = 0;
    int save = 0;
    for (i = 0; i < 10 && x != 0; i++) {
      save = answer;
      answer *= 10;
      answer += x % 10;
      x /= 10;
    }
    if (answer != 0 && answer / (10) != save) {
      return 0;
    }
    return answer;
  }
}
