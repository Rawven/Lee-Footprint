package org.example.lee.题目.滑动窗口;

public class b_最大点数 {

	/**
	 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
	 * 你的点数就是你拿到手中的所有卡牌的点数之和。 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。 max score
	 * TODO 关键思想  可获得的最大点数 = 总数-滑动窗口的min
	 *
	 * @param cardPoints card points
	 * @param k          k
	 * @return int
	 */
	public int maxScore(int[] cardPoints, int k) {
		int left = 0, right = 0, min = 0, record = 0, all = 0, len = cardPoints.length;
		while (right < len) {
			min += cardPoints[right];
			all += cardPoints[right];
			right++;
			if (right > len - k) {
				min -= cardPoints[left];
				left++;
				if (min < record) {
					record = min;
				}
			} else {
				record = min;
			}

		}
		return all - record;
	}
}
