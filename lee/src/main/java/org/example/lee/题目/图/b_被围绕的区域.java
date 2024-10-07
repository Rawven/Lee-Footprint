package org.example.lee.题目.图;

public class b_被围绕的区域 {

	/**
	 * 给你一个 m x n 的矩阵 board ， 由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域， 并将这些区域里所有的 'O' 用 'X' 填充。 solve
	 *
	 * @param board board
	 */
	public void solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				dfs(board, i, 0);
			}
			if (board[i][board[0].length - 1] == 'O') {
				dfs(board, i, board[0].length - 1);
			}
		}
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O') {
				dfs(board, 0, i);
			}
			if (board[board.length - 1][i] == 'O') {
				dfs(board, board.length - 1, i);
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'A') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	public void dfs(char[][] grid, int i, int j) {
		if (isArea(grid, i, j) && grid[i][j] == 'O') {
			grid[i][j] = 'A';
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
