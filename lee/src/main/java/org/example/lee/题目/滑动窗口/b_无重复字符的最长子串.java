package org.example.lee.题目.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class b_无重复字符的最长子串 {
	public int lengthOfLongestSubstring(String s) {
		char[] charArray = s.toCharArray();
		int max = 0, left = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (map.containsKey(c)) {
				left = Math.max(left,map.get(c) + 1);
			}
			max = Math.max(max, i - left+1);
			map.put(c, i);
		}
		return max;
	}
}
