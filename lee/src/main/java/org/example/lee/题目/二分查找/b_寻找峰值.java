package org.example.lee.题目.二分查找;

public class b_寻找峰值 {

	public int findPeakElement(int[] nums) {
		int left = 0, right = nums.length - 1;
		int i = 0;
		while (left < right) {
			i = left + (right - left) / 2;
			//如果 nums[i]<nums[i+1] 则峰值在右边 left往右走
			if (nums[i] < nums[i + 1]) {
				left = i + 1;
			} else {
				//如果 nums[i]<nums[i+1] 则峰值在左边 right往左走   只要left和right相遇就是峰值
				right = i;
			}
		}
		//如果返回i最后可能是峰值-1
		return left;
	}


}
