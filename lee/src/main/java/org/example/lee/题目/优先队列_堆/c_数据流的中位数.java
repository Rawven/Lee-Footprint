package org.example.lee.题目.优先队列_堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class c_数据流的中位数 {

	class MedianFinder {

		PriorityQueue<Integer> smaller;
		PriorityQueue<Integer> bigger;


		public MedianFinder() {
			smaller = new PriorityQueue<>((a, b) -> (b - a));
			bigger = new PriorityQueue<>((a, b) -> (a - b));
		}

		public void addNum(int num) {
			if (smaller.isEmpty() || num <= smaller.peek()) {
				smaller.offer(num);
				if (bigger.size() + 1 < smaller.size()) {
					bigger.offer(smaller.poll());
				}
			} else {
				bigger.offer(num);
				if (smaller.size() < bigger.size()) {
					smaller.offer(bigger.poll());
				}
			}
		}

		public double findMedian() {
			if ((smaller.size() + bigger.size()) % 2 == 0) {
				return ((double) (smaller.peek() + bigger.peek())) / 2.0;
			} else {
				return smaller.peek();
			}
		}
	}

}
