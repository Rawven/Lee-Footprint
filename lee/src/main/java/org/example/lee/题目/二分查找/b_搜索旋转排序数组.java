package org.example.lee.题目.二分查找;

import java.util.Arrays;

public class b_搜索旋转排序数组 {


  /**
   * search 要求 logN 二分法 然后找出有序的空间和无序的空间 有序则继续二分 无序则递归
   *
   * @param nums   nums
   * @param target target
   * @return int
   */
  public static int search(int[] nums, int target) {
    int len = nums.length, mid, left = 0, right = len - 1, res1 = -1, res2 = -1;
    mid = (left + right) / 2;
    if (nums[mid] == target) {
      return mid;
    } else {
      if (nums[mid] > nums[right]) {
        res1 = search(Arrays.copyOfRange(nums, mid + 1, len), target);
        res2 = tool(nums, target, 0, mid - 1);
        if (res1 != -1) {
          return mid + 1 + res1;
        }
        return res2;
      } else if (nums[mid] < nums[left]) {
        res1 = search(Arrays.copyOfRange(nums, 0, mid), target);
        res2 = tool(nums, target, mid + 1, len - 1);
        if (res1 != -1) {
          return res1;
        }
        return res2;
      } else {
        return tool(nums, target, 0, len - 1);
      }

    }
  }

  public static int tool(int[] nums, int target, int left, int right) {
    int middle = 0;
    do {
      middle = (left + right) / 2;
      if (nums[middle] > target) {
        right = middle - 1;
      } else if (nums[middle] < target) {
        left = middle + 1;
      } else {
        return middle;
      }
    } while (left <= right);
    return -1;
  }
}
