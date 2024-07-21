package org.example.lee.题目.贪心;

import java.util.Arrays;
import java.util.Comparator;

public class b_无重叠区间 {

  public int eraseOverlapIntervals(int[][] intervals) {
    int key = 1;
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    for (int i = 0; i < intervals.length - 1; i++) {
      if (intervals[i][0] != intervals[i + 1][0] && intervals[i][1] <= intervals[i + 1][0]) {
        key++;
      } else {
        intervals[i + 1][1] = Math.min(intervals[i][1], intervals[i + 1][1]);
      }
    }
    return intervals.length - key;
  }
}
