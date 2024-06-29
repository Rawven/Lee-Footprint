package org.example.lee.题目.区间;

import java.util.ArrayList;
import java.util.List;

public class a_汇总区间 {

  /**
   * 给定一个  无重复元素 的 有序 整数数组 nums 。 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums
   * 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。 列表中的每个区间范围 [a,b] 应该按如下格式输出： "a->b" ，如果 a != b
   * "a" ，如果 a == b summary ranges
   *
   * @param nums nums
   * @return {@link List}<{@link String}>
   */
  public static List<String> summaryRanges(int[] nums) {
    int len = nums.length;
    int begin = 0;
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < len; i++) {
      if ((i + 1 < len && nums[i] + 1 != nums[i + 1]) || i + 1 >= len) {
        StringBuilder stringBuilder = new StringBuilder();
        if (begin == i) {
          stringBuilder.append(nums[begin]);
        } else {
          stringBuilder.append(nums[begin]).append("->").append(nums[i]);
        }
        list.add(stringBuilder.toString());
        if (i + 1 < len) {
          begin = i + 1;
        }
      }
    }
    return list;
  }
}
