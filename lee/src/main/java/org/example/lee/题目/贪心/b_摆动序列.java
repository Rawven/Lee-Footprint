package org.example.lee.题目.贪心;

public class b_摆动序列 {

	public int wiggleMaxLength(int[] nums) {
		if (nums.length < 1) {
			return nums.length;
		}
		int a, b = 0, result = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			a = nums[i + 1] - nums[i];
			if ((a < 0 && b >= 0) || (a > 0 && b <= 0)) {
				result++;
				b = a;
			}

		}
		return result;
	}
}
