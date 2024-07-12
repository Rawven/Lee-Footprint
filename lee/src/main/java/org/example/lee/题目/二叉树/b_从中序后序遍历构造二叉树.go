package 二叉树

var rootIndex int

func buildTree(inorder []int, postorder []int) *TreeNode {
	//后序遍历的最后一个是头结点
	//通过这个找到中序遍历里头结点的位置
	//就可以找到左子树头结点的位置
	//后序遍历的倒数第二个结点是右子树的头结点
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
