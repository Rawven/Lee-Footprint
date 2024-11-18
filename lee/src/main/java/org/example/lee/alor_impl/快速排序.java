package org.example.lee.alor_impl;

public class 快速排序 {
    public void qk(int[] nums){
		quickSort(nums,0,nums.length-1);
	}

    public void quickSort(int[] nums,int left,int right){
        int mark = partition(nums,left,right);
		quickSort(nums,left,mark-1);
		quickSort(nums,mark+1,right);
	}

	private int partition(int[] nums,int left,int right){
		int mark = left;
		int i = left, j = right;
		while(i < j){
            while(i < j && nums[j]>=nums[mark]){
				j--;
			}
			while(i < j && nums[i]<=nums[mark]){
				i++;
			}
			swap(nums,i,j);
		} 
		swap(nums,mark,i);
        return i;
	}

	private void swap(int[] nums,int i ,int j){
		int v = nums[i];
		nums[i] = nums[j];
		nums[j] = v;
	}
    
	
//	public void swap(int[] nums, int i, int j) {
//		int t = nums[i];
//		nums[i] = nums[j];
//		nums[j] = t;
//	}
//
//	public int partition(int[] nums, int left, int right) {
//		int i = left, j = right,t;
//		while (i < j) {
//			while (i < j && nums[j] >= nums[left]) {
//				j--;
//			}
//			while (i < j && nums[i] <= nums[left]) {
//				i++;
//			}
//			swap(nums, i, j);
//		}
//		swap(nums, left, i);
//		return i;
//	}
//
//	public void qS(int[] nums, int left, int right) {
//		if (left >= right) {
//			return;
//		}
//		int pivot = partition(nums, left, right);
//		qS(nums, left, pivot - 1);
//		qS(nums, pivot + 1, right);
//	}

}
