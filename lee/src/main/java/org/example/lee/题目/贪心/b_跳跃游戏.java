package org.example.lee.题目.贪心;

public class b_跳跃游戏 {

	/**
	 * can jump 贪心
	 *
	 * @param nums nums
	 * @return boolean
	 */
	public boolean canJump(int[] nums) {
		if (nums.length <= 1) {
			return true;
		}
		int max = nums[0], i;
		for (i = 1; i < nums.length && i < max + 1; i++) {
			if (max < i + nums[i]) {
				max = i + nums[i];
				if (max + 1 >= nums.length) {
					return true;
				}
			}

		}
		return i == nums.length;
	}
}


