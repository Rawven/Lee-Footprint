package org.example.lee.题目.栈;

import java.util.Stack;

public class a_用栈实现队列 {

	class MyQueue {

		public Stack<Integer> aStack;
		public Stack<Integer> bStack;


		public MyQueue() {
			aStack = new Stack<>();
			bStack = new Stack<>();
		}

		public void push(int x) {
			aStack.push(x);
		}

		public int pop() {
			//压入bStack时就已经成为队列的顺序了，如果不为空就直接pop,为空则从aStack压入bStack
			if (!bStack.isEmpty()) {
				return bStack.pop();
			}
			while (!aStack.isEmpty()) {
				Integer pop = aStack.pop();
				bStack.push(pop);
			}
			return bStack.pop();
		}

		public int peek() {
			if (!bStack.isEmpty()) {
				return bStack.peek();
			}
			while (!aStack.isEmpty()) {
				Integer pop = aStack.pop();
				bStack.push(pop);
			}
			return bStack.peek();
		}

		public boolean empty() {
			return aStack.isEmpty() && bStack.isEmpty();
		}
	}
}
