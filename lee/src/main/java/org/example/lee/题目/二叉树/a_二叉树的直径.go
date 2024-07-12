package 二叉树

var save int

func diameterOfBinaryTree(root *TreeNode) int {
	save = 0
	tool1(root)
	return save - 1
}
func tool1(root *TreeNode) int {
	if root == nil {
		return 0
	}
	a := tool1(root.Left)
	b := tool1(root.Right)
	save = max(save, a+b+1)
	return max(a, b) + 1
}
