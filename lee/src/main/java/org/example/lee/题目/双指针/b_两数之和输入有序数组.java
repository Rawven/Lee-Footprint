package org.example.lee.题目.双指针;

public class b_两数之和输入有序数组 {

  /**
   * two sum 因为必有答案 所以可以直接双指针逼近
   *
   * @param numbers numbers
   * @param target  target
   * @return {@link int[]}
   */
  public int[] twoSum(int[] numbers, int target) {
    int[] list = new int[2];
    int a = 0, b = numbers.length - 1;
    while (true) {
      if (numbers[a] + numbers[b] > target) {
        b--;
      } else if (numbers[a] + numbers[b] < target) {
        a++;
      } else {
        list[0] = a + 1;
        list[1] = b + 1;
        return list;
      }
    }
  }
}
