package 二叉树

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	var arr []int
	help(root, &arr)
	return arr
}
func help(root *TreeNode, arr *[]int) {
	if root == nil {
		return
	}
	help(root.Left, arr)
	*arr = append(*arr, root.Val)
	help(root.Right, arr)
}
