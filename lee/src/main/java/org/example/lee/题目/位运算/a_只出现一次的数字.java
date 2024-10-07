package org.example.lee.题目.位运算;

public class a_只出现一次的数字 {

	public int singleNumber(int[] nums) {
		int a = 0;
		for (int num : nums) {
			//对位运算的考察
			//交换律：a ^ b ^ c <=> a ^ c ^ b
			//
			//任何数于0异或为任何数 0 ^ n => n
			//
			//相同的数异或为0: n ^ n => 0
			//
			a ^= num;
		}
		return a;
	}
}
