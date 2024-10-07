package org.example.lee.题目.贪心;

public class b_单调递增的数字 {

	public int monotoneIncreasingDigits(int n) {
		int i;
		char[] array = String.valueOf(n).toCharArray();
		for (i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				break;
			}
		}
		if (i == array.length - 1) {
			return n;
		}
		while (i > 1 && array[i] == array[i - 1]) {
			i--;
		}
		if (i > 0 && array[i] == array[i - 1]) {
			array[i - 1]--;
		} else {
			array[i]--;
			i++;
		}
		for (int j = i; j < array.length; j++) {
			array[j] = '9';
		}
		long anw = 0;
		for (char c : array) {
			anw += c - '0';
			anw *= 10;
		}
		return (int) (anw / 10);
	}
}
