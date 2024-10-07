package org.example.lee.题目.区间;

import java.util.Arrays;
import java.util.Comparator;

public class b_用最少的剑引爆气球 {

	/**
	 * find min arrow shots 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart,
	 * xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x
	 * 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。
	 * 弓箭一旦被射出之后，可以无限地前进。 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
	 *
	 * @param points points
	 * @return int
	 */
	public int findMinArrowShots(int[][] points) {
		Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
		int key = 0;
		int[] t = null;
		for (int i = 0; i < points.length; i++) {
			if (t == null || t[1] < points[i][0]) {
				//无法覆盖更多的气球  key++
				key++;
			} else if (t[1] < points[i][1]) {
				//记录这根箭的最远距离
				points[i][1] = t[1];
			}
			//更新start位置
			t = points[i];
		}
		return key;
	}
}
