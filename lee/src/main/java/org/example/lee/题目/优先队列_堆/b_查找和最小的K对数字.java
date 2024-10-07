package org.example.lee.题目.优先队列_堆;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class b_查找和最小的K对数字 {

	/**
	 * k smallest pairs 多路归并    教程
	 * https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247490029&idx=1&sn=bba9ddff88d247db310406ee418d5a15&chksm=fd9cb2f2caeb3be4b1f84962677337dcb5884374e5b6b80340834eaff79298d11151da2dd5f7&token=252055586&lang=zh_CN#rd
	 *
	 * @param nums1 nums1
	 * @param nums2 nums2
	 * @param k     k
	 * @return {@link List}<{@link List}<{@link Integer}>>
	 */
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		boolean bo = true;
		if (nums1.length > nums2.length) {
			int[] t = nums1;
			nums1 = nums2;
			nums2 = t;
			bo = false;
		}
		int[] finalNums = nums1;
		int[] finalNums1 = nums2;
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
				(a, b) -> finalNums[a[0]] + finalNums1[a[1]] - finalNums[b[0]] - finalNums1[b[1]]);
		List<List<Integer>> lists = new ArrayList<>();

		for (int i = 0; i < finalNums.length; i++) {

			priorityQueue.offer(new int[]{i, 0});
		}
		while (lists.size() < k) {
			int[] poll = priorityQueue.poll();
			lists.add(bo ? new ArrayList<>() {{
				add(finalNums[poll[0]]);
				add(finalNums1[poll[1]]);
			}} : new ArrayList<>() {{
				add(finalNums1[poll[1]]);
				add(finalNums[poll[0]]);
			}});
			if (poll[1] + 1 < nums2.length) {
				priorityQueue.offer(new int[]{poll[0], poll[1] + 1});
			}
		}
		return lists;
	}
}
