package org.example.lee.题目.字符串;

public class b_轮转数组 {

	/**
	 * rotate 基于客观事实  数组往右移动n个位置 = 先整体翻转+0-n反转+n-len反转
	 *
	 * @param nums nums
	 * @param k    k
	 */
	public void rotate(int[] nums, int k) {
		k=k%nums.length;
		toolToTurnAround(nums,0,nums.length-1);
		toolToTurnAround(nums,0,k-1);
		toolToTurnAround(nums,k,nums.length-1);
	}
	
	void toolToTurnAround(int[] nums,int start,int end){
		while (start < end){
			int h = nums[start];
			nums[start] = nums[end];
			nums[end] = h;
			start++;
			end--;
		}
	}
}
