package org.example.lee.题目.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class b_字母异位词分组 {

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] charArray = str.toCharArray();
			String ori = new String(charArray);
			Arrays.sort(charArray);
			String s = new String(charArray);
			List<String> list = map.computeIfAbsent(s, k -> new ArrayList<>());
			list.add(ori);
		}
		return new ArrayList<>(map.values());
	}
}
