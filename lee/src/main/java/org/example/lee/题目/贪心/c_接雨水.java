package org.example.lee.题目.贪心;

public class c_接雨水 {
	public int trap(int[] height) {
		//记录左侧和右侧的最高点
		int sum = 0, left = 0, leftM = 0, right = height.length - 1, rightM = 0;
		while (left < right) {
			leftM = Math.max(height[left], leftM);
			rightM = Math.max(height[right], rightM);
			//水量只受限于较低的边
			if (leftM > rightM) {
				//添加右侧水量
				sum += rightM - height[right];
				right--;
			} else {
				sum += leftM - height[left];
				left++;
			}
		}
		return sum;
	}
}
