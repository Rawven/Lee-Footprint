package org.example.lee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {
	class Solution {
		int i;

		public String decodeString(String s) {
			i = 0;
			return tool(s);
		}

		String tool(String s) {
			StringBuilder sb = new StringBuilder();
			StringBuilder result = new StringBuilder();
			int multi = 0;
			while (i < s.length()) {
				char c = s.charAt(i);
				if (isNumber(c)) {
					multi = multi * 10 + (c - '0');
				} else if (c == '[') {
					sb.append(tool(s).repeat(multi));
				} else {
					result.append(sb);
					if (s.charAt(i + 1) != '[') {
						return result.toString();
					} else {
						sb = new StringBuilder();
					}
				}
				i++;
			}
			return result.toString();
		}

		boolean isNumber(char c) {
			return c >= '0' && c <= '9';
		}
	}
}
