package org.example.lee.题目.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class c_串联所有单词的字串 {


	public static List<Integer> findSubstring(String s, String[] words) {
		ArrayList<Integer> list = new ArrayList<>();
		int index = 0, strLen = s.length(), arrayLen = words.length, wordLen = words[0].length();
		int[] arrayW = new int[arrayLen];
		HashMap<String, Integer> map = new HashMap<>(arrayLen);
		for (String word : words) {
			if (!map.containsKey(word)) {
				map.put(word, index);
				index++;
			}
			arrayW[map.get(word)]++;
		}
		for (int j = 0; j < wordLen && wordLen * arrayLen + j <= strLen; j++) {
			int[] arrayS = new int[arrayLen];
			for (int i = j; i < wordLen * arrayLen + j; i += wordLen) {
				String str = s.substring(i, i + wordLen);
				if (map.containsKey(str)) {
					arrayS[map.get(str)]++;
				}
			}
			if (Arrays.equals(arrayW, arrayS)) {
				list.add(j);
			}
			for (int i = j + wordLen; i <= strLen - arrayLen * wordLen; i += wordLen) {
				String deleteWord = s.substring(i - wordLen, i);
				if (map.containsKey(deleteWord)) {
					arrayS[map.get(deleteWord)]--;
				}
				String addWord = s.substring(i + (arrayLen - 1) * wordLen, i + arrayLen * wordLen);
				if (map.containsKey(addWord)) {
					arrayS[map.get(addWord)]++;
				}
				if (Arrays.equals(arrayW, arrayS)) {
					list.add(i);
				}
			}
		}
		return list;
	}
}
