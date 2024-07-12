package main

import (
	_ "container/list"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(inorder []int, postorder []int) *TreeNode {
	//后序遍历的最后一个是头结点
	//通过这个找到中序遍历里头结点的位置
	//就可以找到左子树头结点的位置
	//后序遍历的倒数第二个结点是右子树的头结点
	return toool(inorder, postorder, 0, len(postorder)-1)
}

func toool(inorder, postorder []int, x, y int) *TreeNode {
	root := &TreeNode{
		Val:   postorder[y],
		Left:  nil,
		Right: nil,
	}
	if x != y {
		var i int
		for i = x; i < y; i++ {
			if inorder[i] == postorder[y] {
				break
			}
		}
		if x <= i-1 {
			root.Left = toool(inorder, postorder, x, i-1)
		}
		if i+1 <= y-1 {
			root.Right = toool(inorder, postorder, i, y-1)
		}
	}
	return root
}
func main() {
	buildTree([]int{9, 3, 15, 20, 7}, []int{9, 15, 7, 20, 3})
}
