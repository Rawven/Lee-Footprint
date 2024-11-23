package org.example.lee;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] charArray = str.toCharArray();
//			Arrays.sort(charArray);
//			String key = Arrays.toString(charArray);
			//计数排序做法
			int[] arr = new int[26];
			for (char c : charArray){
				arr[c-'a']++;
			}
			String key = Arrays.toString(arr);
			List<String> theList = map.computeIfAbsent(key, v -> new ArrayList<>());
			theList.add(str);
		}
		return new ArrayList<>(map.values());
	}
}
