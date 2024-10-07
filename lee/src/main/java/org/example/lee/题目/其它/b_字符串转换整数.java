package org.example.lee.题目.其它;

public class b_字符串转换整数 {


	public int myAtoi(String s) {
		int index = 0, isPositive = 1, len = s.length();
		long i = 0;
		char c;
		if (s.isEmpty()) {
			return 0;
		}
		while (index < s.length() && s.charAt(index) == ' ') {
			index++;
		}
		if (index == s.length()) {
			return 0;
		}
		c = s.charAt(index);
		if (c == '-' || c == '+') {
			if (c == '-') {
				isPositive = -1;
			}
			index++;
		}
		while (index < len && s.charAt(index) <= 57 && s.charAt(index) >= 48
		) {
			i *= 10;
			i += s.charAt(index) - 48;
			if (isPositive * i > 2147483647 || isPositive * i < -2147483648) {
				if (isPositive * i > 0) {
					return 2147483647;
				}
				return -2147483648;
			}
			index++;
		}
		return (int) i * isPositive;
	}
}
