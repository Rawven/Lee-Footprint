package org.example.lee.题目.栈;

import java.util.Deque;
import java.util.LinkedList;

public class b_移掉k位数字 {

	public String removeKdigits(String num, int k) {
		Deque<Character> deque = new LinkedList<>();
		int length = num.length();
		if (length == k) {
			return "0";
		}
		int i = 0;
		int j = k;
		StringBuilder sb = new StringBuilder();
		//TODO 贪心策略  尽可能让前面的数字小
		while (i < length) {
			while (!deque.isEmpty() && j > 0 && num.charAt(i) < deque.peekLast()) {
				deque.pollLast();
				j--;
			}
			deque.offerLast(num.charAt(i));
			i++;
		}
		while (j > 0) {
			deque.pollLast();
			j--;
		}
		while (!deque.isEmpty() && deque.peekFirst() == '0') {
			deque.pollFirst();
		}
		while (!deque.isEmpty()) {
			Character c = deque.pollFirst();
			sb.append(c);
		}
		return sb.toString().isEmpty() ? "0" : sb.toString();
	}
}
