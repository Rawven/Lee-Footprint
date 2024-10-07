package org.example.lee.题目.其它;

public class b_寻找重复数字 {
	/**
	 * 把数组当作链表，里面的值当作指针
	 * 和这个题很像
	 * org.example.lee.题目.链表.b_环形链表Ⅱ
	 */
	public int findDuplicate(int[] nums) {
		int slow = 0, fast = 0;
		//先在环里第一次相遇
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		slow = 0;
		//然后慢指针回到起点再来一次，套路一模一样
		do {
			slow = nums[slow];
			fast = nums[fast];
		} while (slow != fast);

		return slow;
	}
}
