package org.example.lee.题目.贪心;

public class b_盛最多水的容器 {

	public int maxArea(int[] height) {
		int head = 0, end = height.length - 1;
		int max = 0;
		while (head < end) {
			int a = height[head], b = height[end];
			if (a > b) {
				max = Math.max(max, b * (end - head));
				end--;
			} else {
				max = Math.max(max, a * (end - head));
				head++;
			}
		}
		return max;
	}

}
