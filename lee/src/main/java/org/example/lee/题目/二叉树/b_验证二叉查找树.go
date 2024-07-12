package 二叉树

// 直接中序遍历判断大小关系就行
var now int
var status int

func isValidBST(root *TreeNode) bool {
	now, status = 0, 0
	return ttool(root)
}
func ttool(root *TreeNode) bool {
	if root == nil {
		return true
	}
	if ttool(root.Left) != true {
		return false
	}
	if status == 0 {
		status++
	} else if root.Val <= now {
		return false
	}
	now = root.Val
	return ttool(root.Right) == true
}

func isValidBST1(root *TreeNode) bool {
	return tool11(root, nil, nil)
}
func tool11(root, min, max *TreeNode) bool {
	if root == nil {
		return true
	}
	if min != nil && root.Val <= min.Val {
		return false
	}
	if max != nil && root.Val >= max.Val {
		return false
	}
	//递归 刷新最小最大值
	return tool11(root.Left, min, root) && tool11(root.Right, root, max)
}
