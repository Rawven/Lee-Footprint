package 二叉树

var rootIndex int

func buildTree1(inorder []int, postorder []int) *TreeNode {
	//对于中序遍历 实际上有一个分治的思想
	//不断从root结点进行拆分
	//然后后序遍历从右到左，可以保证每次获得的都是右子树
	rootIndex = len(postorder) - 1
	m := make(map[int]int)
	for k, v := range inorder {
		m[v] = k
	}
	return toool(inorder, postorder, 0, len(postorder)-1, m)
}
func toool(inorder, postorder []int, x, y int, m map[int]int) *TreeNode {
	if x > y {
		return nil
	}
	root := &TreeNode{
		Val:   postorder[rootIndex],
		Left:  nil,
		Right: nil,
	}
	rootIndex--
	mid := m[root.Val]
	root.Right = toool(inorder, postorder, mid+1, y, m)
	root.Left = toool(inorder, postorder, x, mid-1, m)
	return root
}

func findMid(inorder []int, root *TreeNode, x, y int) int {
	var mid int
	for mid = x; mid <= y; mid++ {
		if inorder[mid] == root.Val {
			return mid
		}
	}
	return -1
}
