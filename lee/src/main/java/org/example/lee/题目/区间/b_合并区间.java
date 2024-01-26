package org.example.lee.题目.区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class b_合并区间 {

    /**
     * 以数组 intervals 表示若干个区间的集合，
     * 其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，
     * 该数组需恰好覆盖输入中的所有区间 。
     * merge
     *
     * @param intervals intervals
     * @return {@link int[][]}
     */
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                if (intervals[i][1] < intervals[i + 1][1]) {
                    intervals[i + 1][0] = intervals[i][0];
                } else {
                    intervals[i + 1] = intervals[i];
                }
            } else {
                arr.add(intervals[i]);
            }
        }
        arr.add(intervals[intervals.length - 1]);
        return arr.toArray(new int[arr.size()][]);
    }

    /**
     * merge
     *
     * @param intervals intervals
     * @return {@link int[][]}
     */
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (arr.isEmpty() || arr.get(arr.size() - 1)[1] < intervals[i][0]) {
                arr.add(intervals[i]);
            } else {
                int[] a = arr.get(arr.size() - 1);
                if (a[1] < intervals[i][1]) {
                    intervals[i][0] = a[0];
                    arr.set(arr.size() - 1, intervals[i]);
                }
            }
        }
        return arr.toArray(new int[arr.size()][]);
    }
}
