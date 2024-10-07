package org.example.lee.题目.贪心;

public class b_加油站 {

	/**
	 * can complete circuit 这个贪这个好 反正就是cur能<0那这个起点绝对是cost>gas的
	 *
	 * @param gas  gas
	 * @param cost cost
	 * @return int
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0;
		int cur = 0;
		int total = 0;
		for (int i = 0; i < gas.length; i++) {
			cur += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (cur < 0) {
				start = i + 1;
				cur = 0;
			}

		}
		return total < 0 ? -1 : start;
	}

	/**
	 * TODO 旧版 我自己都看不懂了
	 * can complete circuit
	 * 直观理解，不用公式推导。可以这样想：
	 * 假设从x加油站出发经过z加油站最远能到达y加油站，那么从z加油站直接出发，
	 * 不可能到达y下一个加油站。因为从x出发到z加油站时肯定还有存储的油，
	 * 这都到不了y的下一站，
	 * 而直接从z出发刚开始是没有存储的油的，所以更不可能到达y的下一站。
	 *  这就是优化的地方
	 *
	 * @param gas  gas
	 * @param cost cost
	 * @return int
	 */
	public int canCompleteCircuit1(int[] gas, int[] cost) {
		int len = gas.length, i = 0;
		while (i < len) {
			int time = 0, costAll = 0, gasAll = 0;
			while (time < len) {
				int j = (time + i) % len;
				costAll += cost[j];
				gasAll += gas[j];
				if (costAll > gasAll) {
					break;
				}
				time++;
			}
			if (time == len) {
				return i;
			} else {
				i = i + 1 + time;
			}
		}
		return -1;
	}
}
