package 二叉树

var num int

func buildTree(preorder []int, inorder []int) *TreeNode {
	//对于中序遍历 实际上有一个分治的思想
	//不断从root结点进行拆分
	//然后前序遍历从左到右，可以保证每次获得的都是左子树
	m := make(map[int]int)
	num = 0
	for k, v := range inorder {
		m[v] = k
	}
	return buildTreeTool(preorder, inorder, 0, len(inorder)-1, m)

}

func buildTreeTool(preorder []int, inorder []int, x, y int, m map[int]int) *TreeNode {
	if x > y {
		return nil
	}
	root := &TreeNode{
		Val:   preorder[num],
		Left:  nil,
		Right: nil,
	}
	mid := m[preorder[num]]
	num++
	root.Left = buildTreeTool(preorder, inorder, x, mid-1, m)
	root.Right = buildTreeTool(preorder, inorder, mid+1, y, m)
	return root
}
