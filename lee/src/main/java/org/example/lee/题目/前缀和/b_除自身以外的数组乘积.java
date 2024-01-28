package org.example.lee.题目.前缀和;

public class b_除自身以外的数组乘积 {
    /**
     * product except self
     *  前缀积
     * @param nums nums
     * @return {@link int[]}
     */
    public int[] productExceptSelf(int[] nums) {
        int[] key = new int[nums.length];
        key[0] = 1;
        //下三角
        for(int i = 1 ;i<nums.length;i++){
            key[i] = key[i-1]*nums[i-1];
        }
        //上三角
        //h做辅助功能
        int help = 1;
        for(int i = nums.length-2;i>=0;i--){
            help*=nums[i+1];
            key[i] *= help;
        }
        return key;
    }
}
