package org.example.lee.题目.哈希表;

import java.util.HashMap;

public class a_单词规律 {

	public boolean wordPattern(String pattern, String s) {
		HashMap<Character, String> map = new HashMap<>();
		HashMap<String, Character> map1 = new HashMap<>();
		Character c;
		String d, e;
		String[] split = s.split(" ");
		if (split.length != pattern.length()) {
			return false;
		}
		for (int i = 0; i < pattern.length(); i++) {
			c = pattern.charAt(i);
			d = split[i];
			e = map.getOrDefault(c, null);
			if (e == null) {
				if (map1.containsKey(d)) {
					return false;
				}
				map.put(c, d);
				map1.put(d, c);
			} else {
				if (!e.equals(d)) {
					return false;
				}
			}
		}
		return true;
	}

}
