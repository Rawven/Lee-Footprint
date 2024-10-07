package org.example.lee.题目.动态规划;

public class b_最长公共子序列 {
	/**
	 * dp[i][j] =
	 * 1. dp[i - 1][j - 1] + 1 when a1[i-1] == a2[j-1]
	 * 2. Math.max(dp[i-1][j],dp[i][j-1]) when a1[i-1] != a2[j-1]
	 */
	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length(), n = text2.length();
		char[] a1 = text1.toCharArray(), a2 = text2.toCharArray();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (a1[i - 1] == a2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}
}
