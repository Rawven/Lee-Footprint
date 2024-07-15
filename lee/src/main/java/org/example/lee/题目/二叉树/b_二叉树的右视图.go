package 二叉树

import "container/list"

func rightSideView(root *TreeNode) []int {
	l := list.New()
	l.PushFront(root)
	var arr []int
	if root == nil {
		return arr
	}
	for l.Len() > 0 {
		length := l.Len()
		var a *TreeNode
		for i := 0; i < length; i++ {
			a = l.Front().Value.(*TreeNode)
			if a.Left != nil {
				l.PushBack(a.Left)
			}
			if a.Right != nil {
				l.PushBack(a.Right)
			}
			l.Remove(l.Front())
		}
		arr = append(arr, a.Val)
	}
	return arr
}
