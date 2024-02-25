package org.example.lee.题目.哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class b_最长连续序列 {

    /**
     * longest consecutive
     *  O(2n)=O(n)
     * @param nums nums
     * @return int
     */
    public  int longestConsecutive(int[] nums) {
        int max=0,h=0;
        HashSet<Integer> set = new HashSet<>();
        //O(n)
        for (int a : nums) {
            set.add(a);
        }
        //O(n)
        for (int a : new ArrayList<>(set)) {
            h = 0;
            if (!set.contains(a-1)) {
                //所有值只进去一次 所以这里是一共是O(n)
                while (set.contains(a)) {
                    a++;
                    h++;
                }
                max = Math.max(max, h);
            }
        }
        return max;
    }
}
