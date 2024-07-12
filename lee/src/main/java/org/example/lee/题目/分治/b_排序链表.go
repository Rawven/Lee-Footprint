package 分治

type ListNode struct {
	Val  int
	Next *ListNode
}

// 归并排序
func sortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	slow, fast, h := head, head, head
	for fast != nil && fast.Next != nil {
		h = slow
		slow = slow.Next
		fast = fast.Next.Next
	}
	//将左右两段分开
	h.Next = nil
	//递归
	right := sortList(slow)
	left := sortList(head)
	//merge
	head = &ListNode{}
	save := head
	for right != nil && left != nil {
		if right.Val > left.Val {
			head.Next = left
			left = left.Next
		} else {
			head.Next = right
			right = right.Next
		}
		head = head.Next
	}
	if right == nil {
		head.Next = left
	} else {
		head.Next = right
	}
	return save.Next
}
