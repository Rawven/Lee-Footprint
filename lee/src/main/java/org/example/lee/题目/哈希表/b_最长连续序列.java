package org.example.lee.题目.哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class b_最长连续序列 {

    public  int longestConsecutive(int[] nums){
        int key = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for (int num:set){
            int now = 0;
            //如果num-1不存在 则它作为起点
            if(!set.contains(num-1)){
                //因为不为起点的都不会进入while循环，所以时间复杂度仍是n,每个元素只会路过一次
                while (set.contains(num)){
                    num++;
                    now++;
                }
            }
            key = Math.max(key,now);
        }
        return key;
    }


}
