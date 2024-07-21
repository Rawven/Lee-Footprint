package 回溯

func solveNQueens(n int) [][]string {
	var awe [][]string
	arrr := make([][]byte, n)
	for i := 0; i < n; i++ {
		arrr[i] = make([]byte, n) // 为每个内层切片分配内存
		for j := 0; j < n; j++ {
			arrr[i][j] = '.'
		}
	}
	solveTool(n, 0, &awe, []string{}, arrr)
	return awe
}

func solveTool(n, row int, awe *[][]string, arr []string, arrr [][]byte) {
	if n == row {
		temp := make([]string, len(arr))
		copy(temp, arr)
		*awe = append(*awe, temp)
		return
	}
	for i := 0; i < n; i++ {
		if solveHelper(arrr, row, i) {
			arrr[row][i] = 'Q'
			arr = append(arr, string(arrr[row]))
			solveTool(n, row+1, awe, arr, arrr)
			arrr[row][i] = '.'
			arr = arr[:len(arr)-1]
		}
	}
}
func solveHelper(arrr [][]byte, x, y int) bool {
	for i := 0; i < x; i++ {
		if arrr[i][y] == 'Q' {
			return false
		}
	}
	for i, j := x-1, y-1; i >= 0 && j >= 0; i, j = i-1, j-1 {
		if arrr[i][j] == 'Q' {
			return false
		}
	}
	for i, j := x-1, y+1; i >= 0 && j < len(arrr[0]); i, j = i-1, j+1 {
		if arrr[i][j] == 'Q' {
			return false
		}
	}
	return true
}
