package org.example.lee.题目.哈希表;

public class c_寻找缺失的第一个整数 {


  /**
   * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。 first missing
   * positive
   * TODO 难在满足条件
   *  使用原地拉屎(bushi) 原地哈希法 思想就是
   *   要找的最小整数最大就是 nums.length  自己想一下
   *   然后思路就是把位于 0-nums.length-1 内的值放入 它所在的位置
   *   比如 值x 就应该放在 nums[x-1]
   *   最后再遍历一次 看哪个index不满足 nums[i-1] = i 则返回什么值
   *
   * @param nums nums
   * @return int
   */
  public static int firstMissingPositive(int[] nums) {
    int len = nums.length, save2;
    for (int i = 0; i < len; i++) {
      //TODO 一共就会交换最多len次
      //TODO nums[nums[i] - 1] != nums[i] 内含 nums[i]-1 !=i 和 二者元素不相等条件
      while (nums[i] <= len && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
        save2 = nums[nums[i] - 1];
        nums[nums[i] - 1] = nums[i];
        nums[i] = save2;
      }
    }
    int i;
    for (i = 0; i < len; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return i + 1;
  }
}
