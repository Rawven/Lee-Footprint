package 二叉树

func invertTree(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	a := invertTree(root.Left)
	b := invertTree(root.Right)
	root.Left, root.Right = b, a
	return root
}
