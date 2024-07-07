package 链表

func swapPairs(head *ListNode) *ListNode {
	//if head == nil || head.Next == nil {
	//	return head
	//}
	//a := head
	//head = a.Next
	//var c *ListNode
	//for a != nil && a.Next != nil {
	//	b := a.Next.Next
	//	a.Next.Next = a
	//	if c != nil {
	//		c.Next = a.Next
	//	}
	//	c = a
	//	a.Next = b
	//	a = b
	//}
	//return head
	//下方为通用模板
	i := 0
	save := head
	var h, prev *ListNode
	for i < 2 {
		if head == nil {
			return save
		}
		head = head.Next
		i++
	}
	i = 0
	prev = head
	head = save
	for i < 2 {
		//TODO 头插法
		h = head.Next
		if i == 0 {
			//根据情况递归
			head.Next = swapPairs(prev)
		} else {
			head.Next = prev
		}
		prev = head
		head = h
		i++
	}
	return prev
}
