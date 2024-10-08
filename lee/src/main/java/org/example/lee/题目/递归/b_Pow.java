package org.example.lee.题目.递归;

public class b_Pow {

	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n % 2 == 0) {
			return myPow(x * x, n / 2);
		}
		if (n < 0) {
			return 1 / myPow(x, -n);
		}
		return myPow(x, n - 1) * x;
	}
}
