package org.example.lee.题目.滑动窗口;


import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;

public class c_滑动窗口最大值 {

	public static int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> deque = new LinkedList<>();
		int[] result = new int[nums.length - k + 1];
		for (int i = 0; i < k; i++) {
			int num = nums[i];
			while (!deque.isEmpty() && nums[deque.peekLast()] < num) {
				deque.pollLast();
			}
			deque.offerLast(i);
		}
		result[0] = nums[deque.peekFirst()];
		for (int i = k; i < nums.length; i++) {
			int num = nums[i];
			while (!deque.isEmpty() && nums[deque.peekLast()] < num) {
				deque.pollLast();
			}
			deque.offerLast(i);
			while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
				deque.pollFirst();
			}
			result[i - k + 1] = nums[deque.peekFirst()];
		}
		return result;
	}
}
