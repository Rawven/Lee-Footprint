package 链表

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	slow, fast := head, head
	num := 0
	for fast != nil {
		if num > n {
			slow = slow.Next
		}
		num++
		fast = fast.Next
	}
	if num <= n {
		head = head.Next
	} else {
		slow.Next = slow.Next.Next
	}

	return head
}
