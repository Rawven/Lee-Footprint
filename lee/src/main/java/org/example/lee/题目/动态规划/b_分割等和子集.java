package org.example.lee.题目.动态规划;

public class b_分割等和子集 {

	public boolean canPartition(int[] nums) {
		int sum = 0;
		// 计算数组元素的总和
		for (int i : nums) {
			sum += i;
		}
		// 如果总和为奇数，则不可能将其分割成两个和相等的子集
		if (sum % 2 != 0) {
			return false;
		}
		// 目标是找到一个子集，其和为总和的一半
		int awe = sum / 2;

		// 动态规划数组，arr[j]表示是否可以找到和为j的子集
		int[] arr = new int[awe + 1];
		// 遍历每个数字
		for (int i = 0; i < nums.length; i++) {
			// 从后向前遍历，确保每个数字只使用一次
			for (int j = awe; j >= nums[i]; j--) {
				// 更新动态规划数组
				arr[j] = Math.max(arr[j], arr[j - nums[i]] + nums[i]);
			}
		}
		// 如果arr[awe]等于awe，说明可以找到和为awe的子集
		return arr[awe] == awe;
	}

}
