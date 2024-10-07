package org.example.lee.题目.哈希表;

import java.util.HashMap;

/**
 * 两数之和
 *
 * @author 刘家辉
 * @date 2023/11/11
 */
public class a_两数之和 {

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			if (map.containsKey(target - n)) {
				return new int[]{i, map.get(target - n)};
			}
			map.put(n, i);
		}
		return new int[]{};
	}
}
