package org.example.lee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b_四数之和 {
    public static void main(String[] args) {
        fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
    }


    /**
     * four sum
     * 一坨屎
     * @param nums   nums
     * @param target target
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        long realTarget = (long) target;
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int len = nums.length, left, right;
        long twoT;
        for (int i = 0; i < len; i++) {
            if ((nums[i] > 0 && realTarget < nums[i]) || (nums[len - 1] < 0 && target > 0)) {
                return lists;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                left = j + 1;
                right = len - 1;
                while (left < right) {
                    long a = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    twoT = realTarget - a;
                    if (twoT > 0) {
                        left++;
                    } else if (twoT < 0) {
                        right--;
                    } else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        lists.add(list);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return lists;
    }
}
