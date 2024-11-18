package org.example.lee.题目.动态规划;

public class b_完全平方数 {
	public int numSquares(int n) {
		//dp[i]的意思是组成i的最少完全平方数数量
		int[] dp = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			//默认情况是1+1+1.....
			dp[i] = i;
			//开始找数量更少的组合
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];
	}
}
