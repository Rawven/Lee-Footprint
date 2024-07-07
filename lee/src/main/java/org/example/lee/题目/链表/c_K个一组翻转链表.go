package 链表

func reverseKGroup(head *ListNode, k int) *ListNode {
	//固定模板
	i := 0
	a := head
	//判断是否为k个 不是直接返回 是则获得一个下一个区间的首元素
	for i < k {
		if a == nil {
			return head
		}
		a = a.Next
		i++
	}
	i = 0
	for i < k {
		help := head.Next
		if i == 0 {
			//当i=0,让head连接下一个区间的首元素
			head.Next = reverseKGroup(a, k)
		} else {
			//此时a保存的是head翻转后应该连接的元素
			head.Next = a
		}
		a = head
		head = help
		i++
	}
	//最终的a就是头元素
	return a
}
