package org.example.lee.题目.滑动窗口;

import java.util.HashMap;

public class c_最小覆盖子串 {


	public static String minWindow(String s, String t) {
		int[] tem = new int[t.length()];
		int[] answer = new int[t.length()];
		HashMap<Character, Integer> map = new HashMap<>();
		int left = 0, right = 0, key = 0, num = s.length() + 1, a1 = 0, a2 = 0, counter = t.length();
		for (int i = 0; i < t.length(); i++) {
			if (!map.containsKey(t.charAt(i))) {
				map.put(t.charAt(i), key++);
			}
			tem[map.get(t.charAt(i))]++;
		}
		while (right < s.length()) {
			char c = s.charAt(right);
			if (map.containsKey(c)) {
				answer[map.get(c)]++;
				if (answer[map.get(c)] <= tem[map.get(c)]) {
					counter--;
				}
			}
			right++;
			//窗口已经包含所有字符 则进入while 吐出一个字符 则进入下一循环
			while (counter == 0) {
				char c1 = s.charAt(left);
				if (map.containsKey(c1)) {
					int a = map.get(c1);
					answer[a]--;
					if (answer[a] < tem[a]) {
						counter++;
					}
				}
				if (right - left < num) {
					num = right - left;
					a1 = left;
					a2 = right;
				}
				left++;
			}
		}
		return num == s.length() + 1 ? "" : s.substring(a1, a2);
	}


}
