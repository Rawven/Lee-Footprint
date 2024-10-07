package org.example.lee.题目.字符串;

import java.util.Arrays;

public class a_合并两个有序数组 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] nums = Arrays.copyOf(nums1, m);
		int a, b, i;
		i = a = b = 0;
		while (i < nums1.length) {
			if (b >= n || (a < m && nums[a] < nums2[b])) {
				nums1[i] = nums[a++];
			} else {
				nums1[i] = nums2[b++];
			}
			i++;
		}

	}
}
