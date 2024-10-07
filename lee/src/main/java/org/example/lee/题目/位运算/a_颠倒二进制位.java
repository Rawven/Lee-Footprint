package org.example.lee.题目.位运算;

public class a_颠倒二进制位 {

	public int reverseBits(int n) {
		int rev = 0;
		for (int i = 0; i < 32 && n != 0; ++i) {
			//获取最低位
			int a = n & 1;
			//将最低位翻转
			int b = a << (31 - i);
			//将翻转后的位加入rev中
			rev |= b;
			//将n无符号右移一位
			n >>>= 1;
		}
		return rev;
	}
}
