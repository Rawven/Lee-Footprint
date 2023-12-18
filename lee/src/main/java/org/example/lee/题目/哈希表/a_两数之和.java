package org.example.lee.题目.哈希表;

import java.util.HashMap;

/**
 * 两数之和
 *
 * @author 刘家辉
 * @date 2023/11/11
 */
public class a_两数之和 {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，
     * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 主要利用哈希表 达到时间复杂度为n
     *
     * @param nums   nums
     * @param target target
     * @return {@link int[]}
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
