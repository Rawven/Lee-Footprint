package 二叉树

func flatten(root *TreeNode) {
	for root != nil {
		if root.Left != nil {
			left := root.Left
			for left.Right != nil {
				left = left.Right
			}
			left.Right = root.Right
			root.Right = root.Left
			root.Left = nil
		}
		root = root.Right
	}
}
