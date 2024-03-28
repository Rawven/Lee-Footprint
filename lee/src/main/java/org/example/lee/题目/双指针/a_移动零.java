package org.example.lee.题目.双指针;

public class a_移动零 {
    public void moveZeroes(int[] nums) {
        int left = 0 ;
        int  len = nums.length;
        for (int i = 0; i < len; i++) {
             if(nums[i] != 0){
                 nums[left] = nums[i];
                 left++;
             }

        }
        for (int i = left; i < nums.length; i++) {
             nums[i]=0;
        }
    }
}
