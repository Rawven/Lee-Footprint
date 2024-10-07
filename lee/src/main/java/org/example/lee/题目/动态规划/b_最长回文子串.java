package org.example.lee.题目.动态规划;

public class b_最长回文子串 {
	public String longestPalindrome(String s) {
		char[] arr = s.toCharArray();
		boolean[][] dp = new boolean[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = true;
		}

		int begin = 0, maxLen = 1;

		for (int l = 2; l <= s.length(); l++) {
			for (int i = 0; i < s.length(); i++) {
				int j = i + l - 1;
				if (j >= s.length()) {
					break;
				}
				if (arr[i] != arr[j]) {
					dp[i][j] = false;
				} else {
					if (j - i < 3) {
						dp[i][j] = true;
					} else {
						dp[i][j] = dp[i + 1][j - 1];
					}
				}

				if (dp[i][j] && j - i + 1 > maxLen) {

					maxLen = j - i + 1;
					begin = i;
				}
			}
		}
		return s.substring(begin, begin + maxLen);
	}

}
