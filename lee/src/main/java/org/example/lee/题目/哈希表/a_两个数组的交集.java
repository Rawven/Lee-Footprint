package org.example.lee.题目.哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class a_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i:nums1){
           set.add(i);
        }
        for (int i:nums2){
            if(set.contains(i)){
                set.remove(i);
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
