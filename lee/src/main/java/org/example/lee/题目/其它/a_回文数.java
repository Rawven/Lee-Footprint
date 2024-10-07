package org.example.lee.题目.其它;

public class a_回文数 {


	public boolean isPalindrome(int x) {
		int array[] = new int[10];
		int right, left = 0;
		if (x >= 0) {
			for (right = 0; x != 0; right++) {
				array[right] = x % 10;
				x /= 10;
			}
			right--;
			while (left < right) {
				if (array[left++] != array[right--]) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
