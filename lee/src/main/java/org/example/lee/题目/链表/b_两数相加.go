package 链表

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	l := &ListNode{
		Val:  0,
		Next: nil,
	}
	head := l
	h := 0
	var a int
	for l1 != nil || l2 != nil {
		if l1 != nil {
			a += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			a += l2.Val
			l2 = l2.Next
		}
		h = (a + l.Val) / 10
		l.Val = (a + l.Val) % 10
		l.Next = &ListNode{
			Val:  h,
			Next: nil,
		}
		if l1 == nil && l2 == nil {
			if l.Next.Val == 0 {
				l.Next = nil
			}
		}
		l = l.Next
		a = 0
	}
	return head
}
