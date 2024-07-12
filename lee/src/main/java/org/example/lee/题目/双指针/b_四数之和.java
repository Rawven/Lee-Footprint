package org.example.lee.题目.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b_四数之和 {

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    ArrayList<List<Integer>> lists = new ArrayList<>();
    int len = nums.length;
    for (int i = 0; i < len - 3; i++) {
      // 避免重复解
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      // 最小的四数之和大于target，后续不可能满足条件
      if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
      // 当前数与最大的三数之和仍小于target，当前循环不可能满足条件
      if ((long) nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) continue;
      for (int j = i + 1; j < len - 2; j++) {
        // 避免重复解
        if (j > i + 1 && nums[j] == nums[j - 1]) continue;
        int left = j + 1, right = len - 1;
        // 最小的四数之和大于target，后续不可能满足条件
        if ((long) nums[i] + nums[j] + nums[left] + nums[left + 1] > target) break;
        // 当前数与最大的两数之和仍小于target，当前循环不可能满足条件
        if ((long) nums[i] + nums[j] + nums[right] + nums[right - 1] < target) continue;
        while (left < right) {
          long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
          if (sum < target) {
            left++;
          } else if (sum > target) {
            right--;
          } else {
            lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            while (left < right && nums[left] == nums[left + 1]) left++;
            while (left < right && nums[right] == nums[right - 1]) right--;
            left++;
            right--;
          }
        }
      }
    }
    return lists;
  }
}
