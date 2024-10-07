package org.example.lee.题目.位运算;

public class b_只出现一次的数字2 {

	public int singleNumber(int[] nums) {
		int r, a, key = 0;
		for (int i = 0; i < 32; i++) {
			r = 0;
			//将数组都换算成二进制相加 出现三次的数字的和必定%3=0
			for (int num : nums) {
				a = num;
				a >>>= i;
				r += (a & 1);
			}
			if (r % 3 != 0) {
				key |= 1 << i;
			}
		}
		return key;
	}
}
