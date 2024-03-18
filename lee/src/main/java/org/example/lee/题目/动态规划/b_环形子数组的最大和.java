package org.example.lee.题目.动态规划;

public class b_环形子数组的最大和 {
    public int maxSubarraySumCircular(int[] nums) {
        int h=0,h1=0,num=0, max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
        for (int k : nums) {
            num += k;
            h += k;
            max = Math.max(max, h);
            if (h < 0) {
                h = 0;
            }
            h1 += k;
            min = Math.min(min, h1);
            if (h1 > 0) {
                h1 = 0;
            }
        }
        if(min == num){
            return max;
        }
        max = Math.max(max,num-min);
        return max;
    }
    public int maxSubarraySumCircular1(int[] nums) {
        int h=0,num=0, max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
        for (int i = 0 ; i<nums.length ; i++) {
            num += nums[i];
            h += nums[i];
            max = Math.max(max, h);
            if (h < 0) {
                h = 0;
            }
        }
        h =0;
        for (int i = 0 ; i<nums.length ; i++) {
            h += nums[i];
            min = Math.min(min, h);
            if (h > 0) {
                h = 0;
            }
        }
        if(min == num){
            return max;
        }
        max = Math.max(max,num-min);

        return max;
    }
}
