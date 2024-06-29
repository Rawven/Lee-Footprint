package org.example.lee.题目.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b_三数之和 {

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    //第一层循环 取一个数为target
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      int target = -nums[i];
      int left = i + 1;
      int right = nums.length - 1;
      //第二层循环 找两个与target相同的数
      while (left < right) {
        int num = nums[left] + nums[right];
        if (num < target) {
          left++;
        } else if (num > target) {
          right--;
        } else {
          list.add(List.of(nums[left++], nums[right--], nums[i]));
          //找下一种不重复的组合
          while (left < right && nums[left - 1] == nums[left]) {
            left++;
          }
          while (left < right && nums[right] == nums[right + 1]) {
            right--;
          }
        }
      }
    }
    return list;
  }
}
