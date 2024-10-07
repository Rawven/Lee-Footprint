package org.example.lee.题目.二分查找;

public class b_探索二维矩阵 {

	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length;
		int length = m * n;
		int left = 0, right = length - 1;

		while (left <= right) {
			int index = left + (right - left) / 2;
			int result = getNum(matrix, index);
			if (result == target) {
				return true;
			} else if (result > target) {
				right = index - 1;
			} else {
				left = index + 1;
			}
		}
		return false;
	}

	public int getNum(int[][] matrix, int index) {
		int m = matrix.length, n = matrix[0].length;
		int i = index / n;
		int j = index % n;
		return matrix[i][j];
	}
}
