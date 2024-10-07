package org.example.lee.题目.二分查找;

public class b_在排序数组中查找元素的第一个和最后一个位置 {


	//TODO 在二分基础上改造即可
	public static int tooll(int[] nums, int target, int left, int right, boolean isUp) {
		int middle, ans = -1;
		do {
			middle = (left + right) / 2;
			if (nums[middle] > target) {
				right = middle - 1;
			} else if (nums[middle] < target) {
				left = middle + 1;
			} else {
				ans = middle;
				if (isUp) {
					left = middle + 1;
				} else {
					right = middle - 1;
				}
			}
		} while (left <= right);
		return ans;
	}

	public int[] searchRange(int[] nums, int target) {
		int[] ints = {-1, -1};
		ints[0] = tooll(nums, target, 0, nums.length - 1, false);
		ints[1] = tooll(nums, target, 0, nums.length - 1, true);
		return ints;
	}

	/**
	 * search range1 瞎写版本
	 *
	 * @param nums   nums
	 * @param target target
	 * @return {@link int[]}
	 */
	public int[] searchRange1(int[] nums, int target) {
		int len = nums.length;
		int[] res = new int[]{-1, -1};
		if (len == 0) {
			return res;
		}
		int index = tool(nums, target, 0, len - 1), index1;
		if (index != -1) {
			index1 = index;
			do {
				if (index1 + 1 < len && nums[index1 + 1] == target) {
					index1 = tool(nums, target, index1 + 1, len - 1);
				} else {
					res[1] = index1;
					break;
				}
			} while (true);
			index1 = index;
			do {
				if (index1 - 1 >= 0 && nums[index1 - 1] == target) {
					index1 = tool(nums, target, 0, index1 - 1);
				} else {
					res[0] = index1;
					break;
				}
			} while (true);
		}
		return res;
	}

	public int tool(int[] nums, int target, int left, int right) {
		int middle;
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
