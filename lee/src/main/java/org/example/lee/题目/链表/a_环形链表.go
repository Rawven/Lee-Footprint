package 链表

func hasCycle(head *ListNode) bool {
	a, b := head, head.Next
	for a != b {
		if b == nil || b.Next == nil {
			return false
		}
		b = b.Next.Next
		a = a.Next
	}
	return true
}
