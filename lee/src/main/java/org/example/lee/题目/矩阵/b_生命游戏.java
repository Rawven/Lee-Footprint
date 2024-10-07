package org.example.lee.题目.矩阵;

public class b_生命游戏 {

	public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				check(board, i, j);
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] /= 10;
			}
		}
	}

	void check(int[][] board, int i, int j) {
		int key = 0;
		if (i > 0) {
			key += board[i - 1][j] % 10;
		}
		if (j > 0) {
			key += board[i][j - 1] % 10;
		}
		if (i < board.length - 1) {
			key += board[i + 1][j] % 10;
		}
		if (i < board[0].length - 1) {
			key += board[i][j + 1] % 10;
		}
		if (i > 0 && j > 0) {
			key += board[i - 1][j - 1] % 10;
		}
		if (i < board.length - 1 && j < board[0].length - 1) {
			key += board[i + 1][j + 1] % 10;
		}
		if (i > 0 && j < board[0].length - 1) {
			key += board[i - 1][j + 1] % 10;
		}
		if (i < board.length - 1 && j > 0) {
			key += board[i + 1][j - 1] % 10;
		}

		if (board[i][j] == 1) {
			if (key >= 2 && key <= 3) {
				board[i][j] += 10;
			}
		} else {
			if (key == 3) {
				board[i][j] += 10;
			}
		}
	}
}
