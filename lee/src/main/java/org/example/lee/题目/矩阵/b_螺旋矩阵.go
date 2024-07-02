package 矩阵

// 自己模拟下规律就好
func spiralOrder(matrix [][]int) []int {
	var arr []int
	var a int
	lenI, lenJ := len(matrix), len(matrix[0])
	q, p, w := 0, lenI, lenJ
	for a < len(matrix)*len(matrix[0]) {
		for i := q; i < w; i++ {
			arr = append(arr, matrix[q][i])
			a++
		}
		for i := q + 1; i < p; i++ {
			arr = append(arr, matrix[i][w-1])
			a++
		}
		if a >= len(matrix)*len(matrix[0]) {
			break
		}
		for i := w - 2; i >= q; i-- {
			arr = append(arr, matrix[p-1][i])
			a++
		}
		for i := p - 2; i >= q+1; i-- {
			arr = append(arr, matrix[i][q])
			a++
		}
		q++
		p--
		w--
	}
	return arr
}
