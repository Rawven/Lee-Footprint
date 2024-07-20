package 二叉树

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil || root == p || root == q {
		return root
	}
	a := lowestCommonAncestor(root.Left, p, q)
	b := lowestCommonAncestor(root.Right, p, q)
	if a != nil && b != nil {
		return root
	}
	if a != nil {
		return a
	}
	return b
}
