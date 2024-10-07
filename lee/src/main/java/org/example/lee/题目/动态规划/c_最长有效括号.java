package org.example.lee.题目.动态规划;

/**
 * c 最长有效括号
 *
 * @author 刘家辉
 * @date 2023/11/18
 */
public class c_最长有效括号 {

	public int longestValidParentheses(String s) {
		// 动态规划数组，dp[i]表示以第i个字符结尾的最长有效括号长度
		int[] dp = new int[s.length() + 1];
		// 记录最长有效括号的长度
		int max = 0;

		// 从第一个字符开始遍历字符串
		for (int i = 1; i < s.length(); i++) {
			// 如果当前字符是右括号
			if (s.charAt(i) == ')') {
				// 如果前一个字符是左括号，构成一对有效括号
				if (s.charAt(i - 1) == '(') {
					// 更新dp[i]，如果i-2>=0，则加上dp[i-2]的值
					dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
				} else {
					// 如果前一个字符是右括号，检查前一个有效括号的前一个字符是否是左括号
					if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
						// 更新dp[i]，加上前一个有效括号的长度和2
						dp[i] = dp[i - 1] + 2;
						// 如果i-2-dp[i-1]>=0，则加上dp[i-2-dp[i-1]]的值
						dp[i] += i - 2 - dp[i - 1] >= 0 ? dp[i - 2 - dp[i - 1]] : 0;
					}
				}
			}
			// 更新最大长度
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}
