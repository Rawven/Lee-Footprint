package org.example.lee.题目.栈;

import java.util.Stack;

public class c_基本计算器 {


	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int i = 0, anw = 0, sign = 1;
		long save;
		//初始符号为正
		stack.push(1);
		while (i < s.length()) {
			if (s.charAt(i) == '+') {
				//同当前源符号
				sign = stack.peek();
			} else if (s.charAt(i) == '-') {
				//同当前源符号的反
				sign = -stack.peek();
			} else if (s.charAt(i) == '(') {
				//记录括号前的作为当前源符号
				stack.push(sign);
			} else if (s.charAt(i) == ')') {
				//离开当前括号
				stack.pop();
			} else if (!(s.charAt(i) == ' ')) {
				//遭遇数字
				save = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					save = save * 10 + s.charAt(i) - '0';
					i++;
				}
				i--;
				anw += (int) (sign * save);
			}
			i++;
		}
		return anw;
	}

}
