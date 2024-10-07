package org.example.lee.题目.队列;

public class a_字符串中的第一个唯一字符 {

	public int firstUniqChar(String s) {
		int[] arr = new int[26];
		int answer = -1;
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (arr[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}
}
