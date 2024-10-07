package org.example.lee.题目.其它;

public class a_字符串相加 {


	/**
	 * add strings 如题 不准用 BigInteger之类的
	 *
	 * @param num1 num1
	 * @param num2 num2
	 * @return {@link String}
	 */
	public String addStrings(String num1, String num2) {
		int len1 = num1.length(), len2 = num2.length();
		int tool = '0', tool2 = 0, save = 0;
		StringBuilder sb = new StringBuilder();
		while (len1 > 0 || len2 > 0 || save > 0) {
			if (len1 > 0) {
				tool2 += (num1.charAt(len1 - 1) - tool);
				len1--;
			}
			if (len2 > 0) {
				tool2 += (num2.charAt(len2 - 1) - tool);
				len2--;
			}
			tool2 += save;
			sb.append((char) (tool2 % 10 + '0'));
			save = tool2 / 10;
			tool2 = 0;
		}
		return sb.reverse().toString();
	}

}
