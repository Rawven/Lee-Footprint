package org.example.lee.题目.二分查找;

public class a_二分查找 {

	/**
	 * search 标准实现
	 *
	 * @param nums   nums
	 * @param target target
	 * @return int
	 */
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1, middle = 0;
		do {
			middle = (left + right) / 2;
			if (nums[middle] > target) {
				right = middle - 1;
			} else if (nums[middle] < target) {
				left = middle + 1;
			} else {
				return middle;
			}
		} while (left <= right);
		return -1;
	}
}
