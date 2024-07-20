package 二叉树

func pathSum(root *TreeNode, targetSum int) int {
	return findPaths(root, targetSum, []int{})
}

func findPaths(root *TreeNode, target int, currentPath []int) int {
	if root == nil {
		return 0
	}
	var help, num int
	currentPath = append(currentPath, root.Val)
	//倒序模拟每一条路线
	for i := len(currentPath) - 1; i >= 0; i-- {
		help += currentPath[i]
		if help == target {
			num++
		}
	}
	num += findPaths(root.Left, target, currentPath)
	num += findPaths(root.Right, target, currentPath)
	return num
}

// 深度优先做法 穷举所有可能
//var key int
//
//func pathSum(root *TreeNode, targetSum int) int {
//	key = 0
//	pathSum1(root, targetSum)
//	return key
//}
//func pathSum1(root *TreeNode, targetSum int) {
//	if root == nil {
//		return
//	}
//	pathSumTool(root, targetSum, 0)
//	pathSum1(root.Left, targetSum)
//	pathSum1(root.Right, targetSum)
//}
//
//func pathSumTool(root *TreeNode, target int, save int) {
//	if root == nil {
//		return
//	}
//	save += root.Val
//	if save == target {
//		key++
//	}
//	pathSumTool(root.Left, target, save)
//	pathSumTool(root.Right, target, save)
//}
