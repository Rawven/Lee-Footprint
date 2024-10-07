package org.example.lee.题目.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b_三数之和 {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			int left = i + 1, right = nums.length - 1, target = -1 * nums[i];
			while (left < right) {
				int a = nums[left], b = nums[right], num = a + b;
				if (num == target) {
					list.add(List.of(a, b, -target));
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					left++;
					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}
				} else if (num > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		return list;
	}
}
