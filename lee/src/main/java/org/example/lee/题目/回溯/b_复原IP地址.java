package org.example.lee.题目.回溯;

import java.util.ArrayList;
import java.util.List;

public class b_复原IP地址 {

	/**
	 * 麻烦点在于模拟规则
	 *
	 * @param s s
	 * @return {@link List }<{@link String }>
	 */
	public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<>();
		if (s.length() > 12) {
			return list;
		}
		tool(list, 0, 0, new StringBuilder(s));
		return list;
	}

	private void tool(List<String> list, int start, int point, StringBuilder s) {
		if (start == s.length()) {
			list.add(s.substring(0, s.length() - 1));
			return;
		}
		for (int i = start; i < s.length() && i < start + 3; i++) {
			String substring = s.substring(start, i + 1);
			if (tool(substring, point + 1, s.length() - start)) {
				s.insert(i + 1, '.');
				point++;
				tool(list, i + 2, point, s);
				point--;
				s.deleteCharAt(i + 1);
			}
		}
	}

	boolean tool(String s, int point, int len) {
		if (s.charAt(0) == '0' && s.length() > 1) {
			return false;
		}
		double a = len - s.length();
		double b = a / (double) (4 - point);
		if (b > 3 || b < 1) {
			return false;
		}
		int i = Integer.parseInt(s);
		return i <= 255 && i >= 0;
	}

}
