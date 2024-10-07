package org.example.lee.题目.动态规划;

public class a_爬楼梯 {


	/**
	 * climb stairs
	 * TODO :
	 *  1.状态定义 动态规划[i] = 爬到 i 阶的方案数
	 *  2. 状态转移方程 ： 动态规划[i] = 动态规划[i-1] + 动态规划[i-2];
	 *  3. 初始条件 ： 动态规划[1]=1 动态规划[2] =2
	 *  4. 返回值： 动态规划[n]
	 *
	 * @param n n
	 * @return int
	 */
	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int dp[] = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		return dp[n];
	}
}
