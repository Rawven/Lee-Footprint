package org.example.lee.题目.动态规划;

public class b_最小路径和 {

	/**
	 * 动态规划[i]
	 *
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] awe = new int[m][n];
		awe[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			awe[i][0] = grid[i][0] + awe[i - 1][0];
		}
		for (int i = 1; i < n; i++) {
			awe[0][i] = grid[0][i] + awe[0][i - 1];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				awe[i][j] = grid[i][j] + Math.min(awe[i - 1][j], awe[i][j - 1]);
			}
		}
		return awe[m - 1][n - 1];

	}
}
