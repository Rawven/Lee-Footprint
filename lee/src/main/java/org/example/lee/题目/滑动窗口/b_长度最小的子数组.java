package org.example.lee.题目.滑动窗口;

public class b_长度最小的子数组 {

	public int minSubArrayLen(int target, int[] nums) {
		int len = nums.length, key = len + 1, num = 0, right = 0, left = 0, choice = 0;
		for (int i = 0; i < len; i++) {
			if (target <= num) {
				num -= nums[left];
				left++;
			}
			while (num < target && right < len) {
				num += nums[right];
				right++;
			}
			if (num >= target) {
				key = Math.min(key, right - left);
			}
		}
		if (key == len + 1) {
			return 0;
		}
		return key;
	}
}
