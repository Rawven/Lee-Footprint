package org.example.lee.题目.双指针;

import org.example.lee.util.LeeUtil;

public class a_有序数组的平方 {

  public static void main(String[] args) {
    sortedSquares(LeeUtil.getArray("[[-4,-1,0,3,10]]")[0]);
  }

  public static int[] sortedSquares(int[] nums) {
    int left = 0, right = 0;
    for (int i = 1; i < nums.length; i++) {
      right = i;
      left = i - 1;
      if (nums[i] > 0) {
        break;
      }
    }
    int[] arr = new int[nums.length];
    int index = 0;
    while (index < nums.length && (left >= 0 || right < nums.length)) {
      if (left < 0) {
        arr[index++] = nums[right] * nums[right];
        right++;
      } else if (right >= nums.length) {
        arr[index++] = nums[left] * nums[left];
        left--;
      } else if (nums[left] * nums[left] < nums[right] * nums[right]) {
        arr[index++] = nums[left] * nums[left];
        left--;
      } else {
        arr[index++] = nums[right] * nums[right];
        right++;
      }
    }
    return arr;
  }
}
