package org.example.lee.题目.双指针;

public class b_下一个排列 {
	public void nextPermutation(int[] nums) {
		// 从数组末尾开始，找到第一个不满足升序的元素
		int i = nums.length - 2, j = nums.length - 1;
		for (; i >= 0 && nums[i] >= nums[j]; i--, j--) {
			// 空循环体，i和j在循环条件中更新
		}

		// 如果找到了这样的元素
		if (i >= 0) {
			// 从数组末尾开始，找到第一个大于nums[i]的元素
			j = nums.length - 1;
			while (nums[i] >= nums[j]) {
				j--;
			}
			// 交换nums[i]和nums[j]
			int a = nums[j];
			nums[j] = nums[i];
			nums[i] = a;
		}

		// 反转i之后的所有元素
		for (i += 1, j = nums.length - 1; i < j; i++, j--) {
			int a = nums[j];
			nums[j] = nums[i];
			nums[i] = a;
		}
	}
}
