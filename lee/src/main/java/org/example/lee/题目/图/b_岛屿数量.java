package org.example.lee.题目.图;

public class b_岛屿数量 {

	/**
	 * num islands 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
	 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 此外，你可以假设该网格的四条边均被水包围。
	 *
	 * @param grid grid
	 * @return int
	 */
	public int numIslands(char[][] grid) {
		int len = grid.length, key = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					key++;
				}
			}
		}
		return key;
	}

	public void dfs(char[][] grid, int i, int j) {
		if (isArea(grid, i, j) && grid[i][j] == '1') {
			grid[i][j] = '2';
			dfs(grid, i, j - 1);
			dfs(grid, i, j + 1);
			dfs(grid, i + 1, j);
			dfs(grid, i - 1, j);
		}
	}

	public boolean isArea(char[][] grid, int i, int j) {
		return i >= 0 && j < grid[0].length && j >= 0 && i < grid.length;
	}
}
