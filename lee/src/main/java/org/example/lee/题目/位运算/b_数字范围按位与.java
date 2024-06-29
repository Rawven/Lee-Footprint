package org.example.lee.题目.位运算;

public class b_数字范围按位与 {

  public int rangeBitwiseAnd(int left, int right) {
    int a = 0;
    while (left < right) {
      //例1 ： 10010和100（= 00100） 一定会经过 10000^100 导致全为0
      //例2 ： 10100和10000 最终只有10000会留下来
      // 实际上就是求最长前缀和
      //
      left >>= 1;
      right >>= 1;
      a++;
    }
    left <<= a;
    return left;
  }
}
