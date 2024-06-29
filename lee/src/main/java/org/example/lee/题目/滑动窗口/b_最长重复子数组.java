package org.example.lee.题目.滑动窗口;

public class b_最长重复子数组 {

  public int findLength(int[] nums1, int[] nums2) {
    int a = nums1.length, b = nums2.length;
    // +1是方便不用处理边界情况
    int[][] d = new int[a + 1][b + 1];
    int key = 0;
    for (int i = a - 1; i >= 0; i--) {
      for (int j = b - 1; j >= 0; j--) {
        if (nums1[i] == nums2[j]) {
          d[i][j] += d[i + 1][j + 1] + 1;
          key = Math.max(key, d[i][j]);
        }
      }
    }
    return key;
  }
}
