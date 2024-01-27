package org.example.lee.题目.字符串;

public class b_轮转数组 {

    /**
     * rotate
     * 基于客观事实  数组往右移动n个位置 = 先整体翻转+0-n反转+n-len反转
     * @param nums nums
     * @param k    k
     */
    public void rotate(int[] nums, int k) {
        int rk = k%nums.length;
        tool(nums,0,nums.length-1);
        tool(nums,0,rk-1);
        tool(nums,rk,nums.length-1);
    }
    void tool(int[] nums,int s,int e){
        while (s<e){
            int i = nums[s];
            nums[s]=nums[e];
            nums[e]=i;
            s++;e--;
        }
    }
}
