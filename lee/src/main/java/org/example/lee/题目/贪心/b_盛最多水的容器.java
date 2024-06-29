package org.example.lee.题目.贪心;

public class b_盛最多水的容器 {

  public int maxArea(int[] height) {
    int left = 0, right = height.length - 1, max = 0;
    //两边往里缩 哪边小哪边缩 贪心就完事了
    while (left < right) {
      max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
      if (height[left] > height[right]) {
        right--;
      } else {
        left++;
      }
    }
    return max;
  }

}
