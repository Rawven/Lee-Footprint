package org.example.lee.题目.递归;

import java.util.Stack;

public class b_字符串解码 {

	public static int i = 0;

	static String tool(String s) {
		Stack<Integer> stack = new Stack<>();
		StringBuilder save = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		int help = 1;
		Integer pop;
		while (help >= 1) {
			if (i >= s.length()) {
				break;
			}
			char c = s.charAt(i++);
			switch (c) {
				case '[':
					help = 2;
					break;
				case ']':
					pop = stack.pop();
					String str = sb.toString();
					save.append(str.repeat(Math.max(0, pop)));
					help = 0;
					break;
				default:
					if (c >= '0' && c <= '9') {
						if (stack.isEmpty()) {
							stack.add(c - '0');
						} else if (help != 2 && sb.length() == 0) {
							pop = stack.pop();
							stack.add(10 * pop + (c - '0'));
						} else {
							i--;
							sb.append(tool(s));
						}
					} else {
						sb.append(c);
					}
			}
		}
		return save.toString();
	}

	public String decodeString(String s) {
		return tool("1[" + s + "]");
	}
}
