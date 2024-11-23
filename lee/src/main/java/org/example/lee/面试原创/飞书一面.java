package org.example.lee.面试原创;

import java.util.HashMap;
import java.util.Map;

public class 飞书一面 {
	/**
	 * 小变种 主要是题意让人容易想到滑动窗口去 实际上是前缀和 https://leetcode
	 * .cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2
	 * &envId=top-100-liked
	 * /给定一个数组和一个数字来玩一个游戏,计算达到目标需要的最小步骤数
	 * //步骤:每次你可以从数组最左边或者最右边取一个数字
	 * //目标:取的所有数字之和等于目标数字
	 * //例:
	 * //输入数组:[1,2,3,4,5,6]
	 * //输入目标:6
	 * //输出:1
	 * //输入数组:[1,2,3,4,5,6]
	 * //输入目标:7
	 * //输出:2
	 */
	int getMinTool(int[] arr, int target) {
		int sum = 0, h = 0, max = 0;
		for (int a : arr) {
			sum += a;
		}
		target = sum - target;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			h += arr[i];
			if (map.containsKey(h - target)) {
				max = Math.max(max, i - map.get(h - target));
			}
			map.putIfAbsent(h, i);
		}
		return arr.length - max;
	}
}
