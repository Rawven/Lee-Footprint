package 链表

// 数学题
// 假设头部到环头部的距离为a,环头部到相遇点距离为b,相遇点到环头部距离为c
// 假设 一快一慢指针 快是慢的2倍速度
// 直接假设 慢指针入环后一圈没转就被追上
// 有 2(a+b) = a+b+c+b
// 解得 a = c
// 代码模拟即可
func detectCycle(head *ListNode) *ListNode {
	a, b := head, head
	for a != nil && b != nil && b.Next != nil && a != b {
		a = a.Next
		b = b.Next.Next
	}
	if a == nil || b == nil || b.Next == nil {
		return nil
	}
	for head != a {
		a = a.Next
		head = head.Next
	}
	return head
}
