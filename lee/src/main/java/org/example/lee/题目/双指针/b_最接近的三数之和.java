package org.example.lee.题目.双指针;

import java.util.Arrays;

public class b_最接近的三数之和 {

  public static void main(String[] args) {
    threeSumClosest(new int[]{-2, -1, 1, 4}, 0);
  }


  /**
   * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 返回这三个数的和。
   * 假定每组输入只存在恰好一个解。 three sum closest 写出来容易 跑的快难
   *
   * @param nums   nums
   * @param target target
   * @return int
   */
  public static int threeSumClosest(int[] nums, int target) {
    int len = nums.length;
    Arrays.sort(nums);
    int right, left, sum = nums[0] + nums[1] + nums[2], sumO = Math.abs(
        target - nums[0] - nums[1] - nums[2]), abs, a;
    for (int i = 0; i < len - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      //TODO 绿色部分为抄的优化 其它自己写的
      a = nums[i] + nums[i + 1] + nums[i + 2];
      if (a > target) {
        if (Math.abs(target - a) < sumO) {
          sum = a;
        }
        return sum;
      }
      a = nums[i] + nums[len - 1] + nums[len - 2];
      if (a < target) {
        if (Math.abs(target - a) < sumO) {
          sumO = Math.abs(target - a);
          sum = a;
        }
        continue;
      }
      //TODO
      left = i + 1;
      right = len - 1;
      while (left < right) {
        a = nums[i] + nums[left] + nums[right];
        abs = Math.abs(target - a);
        if (abs == 0) {
          return target;
        } else {
          if (abs < sumO) {
            sumO = abs;
            sum = a;
          }
          int a1 = Math.abs(target - (nums[i] + nums[left + 1] + nums[right])),
              b = Math.abs(target - (nums[i] + nums[left] + nums[right - 1]));
          if ((left + 1 < right && a1 == 0) || (b == 0) && left < right - 1) {
            return target;
          }
          if (a1 < b) {
            left++;
          } else {
            right--;
          }
        }
      }

    }
    return sum;
  }
}
