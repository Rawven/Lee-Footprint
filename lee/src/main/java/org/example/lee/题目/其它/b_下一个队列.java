package org.example.lee.题目.其它;

import java.util.Arrays;

public class b_下一个队列 {

	public void nextPermutation(int[] nums) {
		int len = nums.length, right = len - 1, right1 = right, h;
		while (right > 0) {
			if (nums[right] > nums[right - 1]) {
				while (right1 > right) {
					if (nums[right1] > nums[right - 1]) {
						h = nums[right1];
						nums[right1] = nums[right - 1];
						nums[right - 1] = h;
						Arrays.sort(nums, right, len);
						return;
					}
					right1--;
				}
				break;
			}
			right--;
		}
		Arrays.sort(nums);
	}
}
