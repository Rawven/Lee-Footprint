package org.example.lee.题目.二分查找;

public class a_搜索插入位置 {


	/**
	 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 请必须使用时间复杂度为 O(log n) 的算法。 search
	 * insert
	 *
	 * @param nums   nums
	 * @param target target
	 * @return int
	 */
	public int searchInsert(int[] nums, int target) {
		int len = nums.length, left = 0, right = len - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (left != right) {
				if (nums[mid] < target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if (target > nums[left]) {
					return left + 1;
				}
				return left;
			}
		}
		return 0;
	}
}
