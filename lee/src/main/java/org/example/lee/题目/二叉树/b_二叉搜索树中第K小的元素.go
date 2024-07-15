package 二叉树

func kthSmallest(root *TreeNode, k int) int {
	node, _ := ktool(root, k)
	if node != nil {
		return node.Val
	}
	return -1
}

func ktool(root *TreeNode, k int) (*TreeNode, int) {
	if root == nil {
		return nil, k
	}
	a, b := ktool(root.Left, k)
	if a != nil {
		return a, b
	}
	b--
	if b == 0 {
		return root, b
	}
	return ktool(root.Right, b)
}
