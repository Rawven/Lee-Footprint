package 贪心

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var key int

func minCameraCover(root *TreeNode) int {
	key = 0
	i := tool(root)
	if i == 2 {
		key++
	}
	return key
}

func tool(root *TreeNode) int {
	//0 是监控
	//1 被监控
	//2 没被监控
	if root == nil {
		return 1
	}
	left := tool(root.Left)
	right := tool(root.Right)
	if left == 2 || right == 2 {
		key++
		return 0
	}
	if left == 1 && right == 1 {
		return 2
	}
	return 1
}
