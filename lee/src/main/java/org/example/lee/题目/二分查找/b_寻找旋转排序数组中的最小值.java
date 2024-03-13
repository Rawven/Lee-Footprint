package org.example.lee.题目.二分查找;

public class b_寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int left = 0 , right =  nums.length-1;
        int i = 0;
        while (left < right){
            i =  left + (right - left)/2;
            //一直往右找就行
            if(nums[i]>nums[right]){
                left = i+1;
            }else {
                right = i;
            }
        }
        return nums[left];
    }

    public static int findMin1(int[] nums) {
        int left = 0 , right =  nums.length-1;
        int i = 0;
        while (left < right){
            i =  left + (right - left)/2;
            if(nums[i]>nums[i+1]){
                return nums[i+1];
            }
            if(nums[i]>nums[left]){
                left = i+1;
            }else {
                right = i;
            }
        }
        if(left!=0 &&nums[left]>nums[left-1]){
            return nums[0];
        }
        return nums[left];


    }
}
