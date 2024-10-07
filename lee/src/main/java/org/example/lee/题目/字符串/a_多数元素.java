package org.example.lee.题目.字符串;

public class a_多数元素 {

	/**
	 * majority elemen 摩尔投票法
	 *
	 * @param nums nums
	 * @return int
	 */
	public int majorityElement(int[] nums) {
		int answer = 0, key = 0;
		for (int num : nums) {
			if (key == 0) {
				answer = num;
			}
			key += answer == num ? 1 : -1;
		}
		return answer;
	}
}
