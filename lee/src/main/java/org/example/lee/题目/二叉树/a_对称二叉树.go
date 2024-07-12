package 二叉树

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	return tool(root.Left, root.Right)
}

func tool(a, b *TreeNode) bool {
	if a == nil && b == nil {
		return true
	}
	if a == nil || b == nil || (a.Val != b.Val) {
		return false
	}
	return tool(a.Left, b.Right) && tool(a.Right, b.Left)
}
