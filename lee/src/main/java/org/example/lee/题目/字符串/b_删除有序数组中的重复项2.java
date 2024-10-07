package org.example.lee.题目.字符串;

public class b_删除有序数组中的重复项2 {

	public int removeDuplicates(int[] nums) {
		int saveIndex = 0, saveValue = 0, saveCount = 0;
		for (int i = 0; i < nums.length; i++, saveIndex++) {
			nums[saveIndex] = nums[i];
			if (i == 0 || nums[i] != saveValue) {
				saveCount = 1;
				saveValue = nums[i];
			} else {
				saveCount++;
				if (saveCount > 2) {
					saveIndex--;
				}
			}
		}
		return saveIndex;
	}

}
