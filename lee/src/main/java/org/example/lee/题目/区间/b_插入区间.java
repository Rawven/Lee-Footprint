package org.example.lee.题目.区间;

import java.util.ArrayList;

public class b_插入区间 {

    /**
     * insert + 合并区间
     * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     *
     * @param intervals   intervals
     * @param newInterval new interval
     * @return {@link int[][]}
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0) {
            return intervals;
        }
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        ArrayList<int[]> arr = new ArrayList<>();
        int i;
        for (i = 0; i < intervals.length; i++) {
            if (newInterval[0] > intervals[i][1]) {
                arr.add(intervals[i]);
            } else {
                //实际上就是处理好插入 然后就按照合并区间做就行
                if (newInterval[0] < intervals[i][0]) {
                    arr.add(newInterval);
                } else {
                    arr.add(intervals[i]);
                    intervals[i] = newInterval;
                }
                for (; i < intervals.length; i++) {
                    if (arr.get(arr.size() - 1)[1] < intervals[i][0]) {
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
        arr.add(newInterval);
        return arr.toArray(new int[arr.size()][]);
    }
}
