package org.example.lee.题目.栈;

import java.util.Objects;
import java.util.Stack;

public class b_简化路径 {


	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] split = path.split("/");
		int index = 0, save = 0;
		while (index < split.length) {
			String s = split[index];
			if (Objects.equals(s, "..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (!(Objects.equals(s, ".") || s.isEmpty())) {
				stack.push(s);
			}
			index++;
		}
		StringBuilder stringBuilder = new StringBuilder();
		while (!stack.isEmpty()) {
			String pop = stack.pop();
			stringBuilder.insert(0, "/" + pop);
			stringBuilder.append("/").append(pop);
		}
		if (stringBuilder.toString().isEmpty()) {
			return "/";
		}
		return stringBuilder.toString();
	}
}
