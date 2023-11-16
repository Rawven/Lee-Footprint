package org.example.lee.other;

import java.util.HashMap;

public class a_删除有序数组的重复项 {

    /**
     * 根据题意有序版
     * remove duplicates
     *
     * @param nums nums
     * @return int
     */
    public int removeDuplicates(int[] nums) {
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(!(i>0&&nums[i] == nums[i-1])){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }


    /**
     * remove duplicates
     * 哈希表版 比较慢 可以针对无序数组
     * @param nums nums
     * @return int
     */
    public int removeDuplicates1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
