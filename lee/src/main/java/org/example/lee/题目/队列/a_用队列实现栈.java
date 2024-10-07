package org.example.lee.题目.队列;

import java.util.LinkedList;
import java.util.Queue;

public class a_用队列实现栈 {

	class MyStack {

		public Queue<Integer> aqueue;
		public Queue<Integer> bqueue;

		public MyStack() {
			aqueue = new LinkedList<>();
			bqueue = new LinkedList<>();
		}

		public void push(int x) {
			bqueue.add(x);
			while (!aqueue.isEmpty()) {
				bqueue.add(aqueue.poll());
			}
			Queue<Integer> temp = aqueue;
			aqueue = bqueue;
			bqueue = temp;
		}

		public int pop() {
			return aqueue.poll();
		}

		public int top() {
			return aqueue.peek();
		}

		public boolean empty() {
			return aqueue.isEmpty();
		}
	}
}
