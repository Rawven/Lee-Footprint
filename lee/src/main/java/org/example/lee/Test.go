package main

import _ "container/list"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {

	isPalindrome(&ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val: 2,
				Next: &ListNode{
					Val:  1,
					Next: nil,
				},
			},
		},
	})
}
func isPalindrome(head *ListNode) bool {
	a, b, i, i1 := head, head, 0, 0
	var h1 *ListNode
	for b != nil && b.Next != nil {
		i++
		b = b.Next.Next
		a = a.Next
	}
	for a != nil {
		h := a
		a = a.Next
		h.Next = h1
		h1 = h
	}
	for i1 < i {
		i1++
		if h1.Val != head.Val {
			return false
		}
		h1 = h1.Next
		head = head.Next
	}
	return true
}
