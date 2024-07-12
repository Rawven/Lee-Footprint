package 链表

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

func copyRandomList(head *Node) *Node {
	m := make(map[*Node]*Node)
	save := head
	for head != nil {
		m[head] = &Node{
			Val:    head.Val,
			Next:   nil,
			Random: nil,
		}
		head = head.Next
	}
	head = save
	var newHead *Node
	for head != nil {
		newHead = m[head]
		newHead.Next = m[head.Next]
		newHead.Random = m[head.Random]
		head = head.Next
	}
	return m[save]
}
