package org.example.lee.题目.位运算;

public class b_两数相除 {

  public static void main(String[] args) {
    System.out.println(Integer.MIN_VALUE);
  }


  /**
   * divide 逆天负数运算 绝妙避开溢出问题 位运算 牛逼
   *
   * @param dividend dividend
   * @param divisor  divisor
   * @return int
   */
  public static int divide(int dividend, int divisor) {
    int result = 0;
    boolean bool = (dividend > 0) ^ (divisor > 0);
    if (dividend > 0) {
      dividend *= -1;
    }
    if (divisor > 0) {
      divisor *= -1;
    }
    while (dividend <= divisor) {
      int temp_result = -1;
      int temp_divisor = divisor;
      while (dividend <= temp_divisor << 1) {
        //TODO 在这种情况下再进位则会溢出 暂停
        if (temp_divisor <= Integer.MIN_VALUE >> 1) {
          break;
        }
        temp_result <<= 1;
        temp_divisor <<= 1;
      }
      dividend -= temp_divisor;
      result += temp_result;
    }
    //除数与被除数同正负性
    if (!bool) {
      //TODO 因为转换为负数 所以若达到MIN 应该转为MAX吧
      if (result == Integer.MIN_VALUE) {
        return Integer.MAX_VALUE;
      }
      result = -result;
    }
    return result;
  }
}
