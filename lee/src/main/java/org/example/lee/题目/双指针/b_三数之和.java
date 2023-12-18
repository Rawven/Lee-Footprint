package org.example.lee.题目.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class b_三数之和 {


    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
     * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * 你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * three sum
     * 难点在于去重 双指针能保持复杂度在 n²
     *
     * @param nums nums
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int len =nums.length;
        int target,left,right ;
        for (int i = 0; i< nums.length && nums[i]<=0; i++) {
                if(i>0 && nums[i] == nums[i-1]){
                    continue;
                }
                target = -1 * nums[i];
                left = i+1;
                right = len - 1;
                while (left < right) {
                    if (nums[left] + nums[right] > target) {
                        right--;
                    } else if (nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        ArrayList<Integer> objects = new ArrayList<>();
                        objects.add(nums[left]);
                        objects.add(nums[right]);
                        objects.add(nums[i]);
                        lists.add(objects);
                        while (left<right && nums[left] == nums[left+1]){
                            left++;
                        }
                        left++;
                        while (left<right && nums[right] == nums[right-1]){
                            right--;
                        }
                        right--;
                    }
                }

        }
        return lists;
    }

    /**
     * 记录一下自己做的蠢方法
     * three sum first
     *
     * @param nums nums
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public static List<List<Integer>> threeSumFirst(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        Arrays.sort(nums);
        int target,sa;
        for (int i = 0; i< nums.length && nums[i]<=0 ; i++) {
            if (!map1.containsKey(nums[i])) {
                target = -1 * nums[i];
                map1.put(nums[i], 1);
                for (int j = i + 1; j < nums.length; j++) {
                    if (i != j) {
                        sa=j;
                        if (map.containsKey(target - nums[j]) && map.get(target - nums[j]) == i) {
                            ArrayList<Integer> objects = new ArrayList<>();
                            objects.add(nums[i]);
                            objects.add(nums[j]);
                            objects.add(target - nums[j]);
                            lists.add(objects);
                            while (j+1<nums.length &&nums[j] == nums[j+1]){
                                j++;
                            }
                        }
                        map.put(nums[sa], i);

                    }
                }
            }
        }
        return lists;
    }
}
