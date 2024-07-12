package 优先队列_堆

import "container/heap"

type ListNode struct {
	Val  int
	Next *ListNode
}

// 归并合并版
func mergeKLists1(lists []*ListNode) *ListNode {
	return merge(lists, 0, len(lists)-1)
}
func merge(lists []*ListNode, i, j int) *ListNode {
	if i == j {
		return lists[i]
	}
	if i > j {
		return nil
	}
	mid := (i + j) / 2
	return merge2List(merge(lists, i, mid), merge(lists, mid+1, j))
}

func merge2List(left, right *ListNode) *ListNode {
	head := &ListNode{}
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

// 优先队列版
func mergeKLists(lists []*ListNode) *ListNode {
	queue := &NodeHeap{}
	heap.Init(queue)
	for _, v := range lists {
		if v != nil {
			heap.Push(queue, v)
		}
	}
	head := &ListNode{}
	save := head
	for queue.Len() > 0 {
		pop := heap.Pop(queue).(*ListNode)
		if pop.Next != nil {
			heap.Push(queue, pop.Next)
		}
		head.Next = pop
		head = head.Next
	}
	return save.Next
}

type NodeHeap []*ListNode

func (h NodeHeap) Len() int { return len(h) }

func (h NodeHeap) Less(i, j int) bool { return h[i].Val < h[j].Val } // 这里决定 大小顶堆 现在是小顶堆

func (h NodeHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *NodeHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func (h *NodeHeap) Push(x interface{}) { // 绑定push方法，插入新元素
	*h = append(*h, x.(*ListNode))
}
