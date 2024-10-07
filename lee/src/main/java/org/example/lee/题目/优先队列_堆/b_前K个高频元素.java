package org.example.lee.题目.优先队列_堆;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class b_前K个高频元素 {

	public int[] topKFrequent(int[] nums, int k) {
		HashMap<Object, int[]> map = new HashMap<>();
		for (int num : nums) {
			int[] arr = map.getOrDefault(num, new int[]{num, 0});
			arr[1]++;
			map.put(num, arr);
		}
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(
				a -> a[1]
		));
		for (Map.Entry<Object, int[]> m : map.entrySet()) {
			queue.add(m.getValue());
		}
		int[] key = new int[k];
		for (int i = 0; i < k; i++) {
			key[i] = queue.poll()[0];
		}
		return key;
	}

}
