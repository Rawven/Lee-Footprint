package org.example.lee.题目.前缀和;

import java.util.HashMap;
import java.util.Map;

public class b_和为k的子数组 {

	public int subarraySum(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			//一路直着加
			sum += nums[i];
			//遇到屁股有刚好=sum-k的，那相减的那一段就是k
			if (map.containsKey(sum - k)) {
				//看看有多少段就加多少
				count += map.get(sum - k);
			}
			//累加当前数字
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	/**
	 * subarray sum 1400ms的做法
	 *
	 * @param nums nums
	 * @param k    k
	 * @return int
	 */
	public int subarraySum1(int[] nums, int k) {
		int[] front = new int[nums.length];
		if (nums.length == 0) {
			return 0;
		}
		front[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			front[i] = front[i - 1] + nums[i];
		}
		int key = 0;
		for (int i = 0; i < nums.length; i++) {
			if (front[i] == k) {
				key++;
			}
			for (int j = 0; j < i; j++) {
				if (front[i] - front[j] == k) {
					key++;
				}
			}
		}
		return key;
	}
}
