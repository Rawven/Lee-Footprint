package 二叉树

import "container/list"

func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return nil
	}
	var arr [][]int
	l := list.New()
	l.PushFront(root)
	ri := 0
	for l.Len() > 0 {
		leng := l.Len()
		arr = append(arr, []int{})
		for i := 0; i < leng; i++ {
			front := l.Front().Value.(*TreeNode)
			if front.Left != nil {
				l.PushBack(front.Left)
			}
			if front.Right != nil {
				l.PushBack(front.Right)
			}
			arr[ri] = append(arr[ri], front.Val)
			l.Remove(l.Front())
		}
		ri++
	}
	return arr
}
