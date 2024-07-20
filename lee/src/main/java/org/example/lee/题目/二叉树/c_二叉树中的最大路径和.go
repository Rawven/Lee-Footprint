package 二叉树

// 最简写法 和求二叉树的直径思路一样
var m int

func maxPathSum(root *TreeNode) int {
	m = root.Val
	maxPathTool(root)
	return m
}

func maxPathTool(root *TreeNode) int {
	if root == nil {
		return 0
	}
	//通过该max函数，可以规避掉许多情况
	a := max(0, maxPathTool(root.Left))
	b := max(0, maxPathTool(root.Right))
	m = max(m, a+b+root.Val)
	return max(a, b) + root.Val
}
