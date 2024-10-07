package org.example.lee.题目.哈希表;

public class a_有效的字母异位词 {

	public boolean isAnagram(String s, String t) {
		int[] arr = new int[26];
		char c;
		if (s.length() != t.length()) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			arr[c - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			c = t.charAt(i);
			if (arr[c - 'a'] == 0) {
				return false;
			}
			arr[c - 'a']--;
		}
		return true;
	}
}
