package org.example.lee.题目.二分查找;

@SuppressWarnings("all")
public class a_x的平方根 {

	public int mySqrt(int x) {
		int left = 0, right = x, answer = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if ((long) mid * mid <= x) {
				//向下取整 所以只在这里赋值
				answer = mid;
				//left+1,逼近所求值
				left = mid + 1;
			} else {
				//right-1 ,逼近所求值
				right = mid - 1;
			}
		}
		return answer;
	}
}
