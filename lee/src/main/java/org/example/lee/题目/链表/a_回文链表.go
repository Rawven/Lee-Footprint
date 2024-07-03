package 链表

func isPalindrome(head *ListNode) bool {

	a, b := head, head
	var h1 *ListNode
	for b != nil && b.Next != nil {
		//找中点与反转前半段
		b = b.Next.Next
		h := a
		a = a.Next
		h.Next = h1
		h1 = h
	}
	if b != nil {
		a = a.Next
	}
	for a != nil && h1 != nil {
		if h1.Val != a.Val {
			return false
		}
		h1 = h1.Next
		a = a.Next
	}
	return true
}
