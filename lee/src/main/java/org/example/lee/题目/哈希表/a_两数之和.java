package org.example.lee.题目.哈希表;

import java.util.HashMap;

/**
 * 两数之和
 *
 * @author 刘家辉
 * @date 2023/11/11
 */
public class a_两数之和 {

    public int[] twoSum(int[] nums, int target) {
        //使用一个map存取k(值)v(值下标)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i<nums.length ; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
