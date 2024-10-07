package org.example.lee.题目.其它;

public class a_加一 {

	public int[] plusOne(int[] digits) {
		int i = digits.length - 1;
		int a = ++digits[i];
		if (a != 10) {
			return digits;
		}
		while (a == 10) {
			digits[i] = 0;
			i--;
			if (i < 0) {
				break;
			}
			digits[i]++;
			a = digits[i];
		}
		if (i < 0) {
			//因为只有一种特殊情况
			int[] aaa = new int[digits.length + 1];
			aaa[0] = 1;
			return aaa;
		}
		return digits;
	}
}
