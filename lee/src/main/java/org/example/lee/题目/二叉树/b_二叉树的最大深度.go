package 二叉树

func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	a := maxDepth(root.Left)
	b := maxDepth(root.Right)
	return 1 + max(a, b)
}
