package org.example.lee.题目.哈希表;

import java.util.HashMap;

public class b_四数相加Ⅱ {

  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    int key = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i : nums1) {
      for (int j : nums2) {
        map.put(i + j, map.getOrDefault(i + j, 0) + 1);
      }
    }
    for (int i : nums3) {
      for (int j : nums4) {
        key += map.getOrDefault(-(i + j), 0);
      }
    }
    return key;
  }
}
