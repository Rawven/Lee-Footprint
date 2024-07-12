package 二叉树

// 分治大法好
func sortedArrayToBST(nums []int) *TreeNode {
	return nowTool(nums, 0, len(nums)-1)
}

func nowTool(nums []int, left, right int) *TreeNode {
	root := &TreeNode{
		Val:   0,
		Left:  nil,
		Right: nil,
	}
	mid := (left + right) / 2
	root.Val = nums[mid]
	if mid > left {
		root.Left = nowTool(nums, left, mid-1)
	}
	if mid < right {
		root.Right = nowTool(nums, mid+1, right)
	}
	return root
}
