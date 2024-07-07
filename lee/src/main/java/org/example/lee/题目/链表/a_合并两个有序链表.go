package 链表

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	var a, head, c *ListNode
	if list1 == nil || (list2 != nil && list1.Val > list2.Val) {
		head = list2
	} else {
		head = list1
	}
	for list1 != nil && list2 != nil {
		//思路
		// c为要连接的点 如果 list1>list2
		// 那么c就要连接list2 ,然后c变为list2,list2变为next，继续循环
		if list1.Val > list2.Val {
			if c != nil {
				c.Next = list2
			}
			c = list2
			a = list2.Next
			list2.Next = list1
			list2 = a
		} else {
			if c != nil {
				c.Next = list1
			}
			c = list1
			a = list1.Next
			list1.Next = list2
			list1 = a
		}
	}
	return head
}
