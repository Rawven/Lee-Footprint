package org.example.lee.题目.回溯;

public class c_N皇后2 {

	public static boolean isValid(char[][] arr, int columns, int row, int n) {
		for (int i = 0; i < row; i++) {
			if (arr[i][columns] == 'Q') {
				return false;
			}
		}
		for (int a = row - 1, b = columns - 1; a >= 0 && b >= 0; a--, b--) {
			if (arr[a][b] == 'Q') {
				return false;
			}
		}
		for (int a = row - 1, b = columns + 1; a >= 0 && b < n; a--, b++) {
			if (arr[a][b] == 'Q') {
				return false;
			}
		}
		return true;
	}

	/**
	 * total nqueens N皇后改成size
	 *
	 * @param n n
	 * @return int
	 */
	public int totalNQueens(int n) {
		char[][] arrs = new char[n][n];
		for (char[] arr : arrs) {
			for (int i = 0; i < n; i++) {
				arr[i] = '.';
			}
		}
		return solutions(arrs, 0, n);
	}

	public int solutions(char[][] arr, int row, int n) {
		if (row == n) {
			return 1;
		}
		int num = 0;
		for (int i = 0; i < n; i++) {
			if (isValid(arr, i, row, n)) {
				arr[row][i] = 'Q';
				num += solutions(arr, row + 1, n);
				arr[row][i] = '.';
			}
		}
		return num;
	}
}
