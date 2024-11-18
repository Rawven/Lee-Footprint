package org.example.lee.题目.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b_找到字符串中的所有字母异位词 {
	public List<Integer> findAnagrams(String s, String p) {
		if(p.length()>s.length()){
			return new ArrayList<>();
		}
		List<Integer> list = new ArrayList<>();
		int[] arr = new int[26], brr = new int[26];
		for (int i = 0; i < p.length(); i++) {
			arr[s.charAt(i) - 'a']++;
			brr[p.charAt(i) - 'a']++;
		}
		if (Arrays.equals(arr,brr)) {
			list.add(0);
		}
		int len = p.length();
		for (int i = len; i < s.length(); i++) {
			arr[s.charAt(i - len) - 'a']--;
			arr[s.charAt(i) - 'a']++;
			if (Arrays.equals(arr,brr)) {
				list.add(i - len + 1);
			}
		}
		return list;
	}
}
