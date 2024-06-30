package org.example.lee.题目.双指针;

import java.util.Arrays;

public class b_最接近的三数之和 {

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
