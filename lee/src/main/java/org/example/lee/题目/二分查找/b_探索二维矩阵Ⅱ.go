package 二分查找

// Z字型做法
// 从右上角开始找 如果小于target 那它那一行都可以舍弃 因为都小于target
// 如果大于target 那一列都可以舍弃 因为都大于target
func searchMatrix2(matrix [][]int, target int) bool {
	l1, l2 := len(matrix), len(matrix[0])
	x, y := 0, l2-1

	for matrix[x][y] != target {
		if matrix[x][y] > target {
			y--
		} else {
			x++
		}
		if x == l1 || y < 0 {
			return false
		}
	}
	return true
}
