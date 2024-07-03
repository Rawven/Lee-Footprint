package 二分查找

func searchMatrix(matrix [][]int, target int) bool {
	l1, l2 := len(matrix), len(matrix[0])
	left, right := 0, l1*l2
	for left < right {
		a := (left + right) / 2
		b := tool(matrix, a)
		if b == target {
			return true
		}
		if a == left || a == right {
			return false
		}
		if b < target {
			left = a + 1
		} else {
			right = a - 1
		}
	}
	return false
}
func tool(matrix [][]int, i int) int {
	x := i / len(matrix[0])
	y := i % len(matrix[0])
	return matrix[x][y]
}
