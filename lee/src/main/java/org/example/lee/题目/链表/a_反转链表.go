package 链表

func reverseList(head *ListNode) *ListNode {
	n := head
	var h, h1 *ListNode
	for n != nil {
		h = n
		n = n.Next
		h.Next = h1
		h1 = h
	}
	return h1
}
