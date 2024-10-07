package org.example.lee.题目.位运算;

public class a_位1的个数 {

	public int hammingWeight(int n) {
		int key = 0;
		for (int i = 0; i < 32; i++) {
			int a = (n & 1);
			if (a == 1) {
				key++;
			}
			n >>>= 1;
		}
		return key;
	}
}
