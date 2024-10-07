package org.example.lee.题目.动态规划;

public class b_最后一块石头的重量2 {

	public int lastStoneWeightII(int[] stones) {
		int sum = 0;
		for (int i : stones) {
			sum += i;
		}
		int target = sum / 2;
		int[] dp = new int[target + 1];
		for (int i = 0; i < stones.length; i++) {
			for (int j = target; j >= stones[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
			}
		}
		return sum - 2 * dp[target];
	}
}
