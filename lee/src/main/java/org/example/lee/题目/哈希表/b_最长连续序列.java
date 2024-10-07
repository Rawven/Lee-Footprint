package org.example.lee.题目.哈希表;

import java.util.HashSet;
import java.util.Set;

public class b_最长连续序列 {
	public int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		int max = 0;

		for (int num : nums) {
			set.add(num);
		}

		for (int num : set) {
			if (!set.contains(num - 1)) {
				int h = 0;
				while (set.contains(num)) {
					num++;
					h++;
				}
				max = Math.max(max, h);
			}
		}
		return max;
	}
}
