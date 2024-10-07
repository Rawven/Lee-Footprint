package org.example.lee.题目.动态规划;

public class b_编辑距离 {
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		int[][] dp = new int[m + 1][n + 1];
		char[] a1 = word1.toCharArray(), a2 = word2.toCharArray();
		for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= n; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int result = Math.min(dp[i][j - 1], dp[i - 1][j]);
				if (a1[i - 1] == a2[j - 1]) {
					result = Math.min(result, dp[i - 1][j - 1] - 1);
				} else {
					result = Math.min(result, dp[i - 1][j - 1]);
				}
				dp[i][j] = result + 1;
			}
		}
		return dp[m][n];
	}
}
