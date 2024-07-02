package 矩阵

// 题目的需求是常量级的额外空间
func setZeroes(matrix [][]int) {
	//思路是通过第一列和第一行来存储0的标志
	//以下两个变量用于存储第一列和第一行有0的情况
	var firstRowZero, firstCowZero bool
	iLen, jLen := len(matrix), len(matrix[0])
	for i := 0; i < iLen; i++ {
		for j := 0; j < jLen; j++ {
			if matrix[i][j] == 0 {
				if i == 0 {
					firstCowZero = true
				}
				if j == 0 {
					firstRowZero = true
				}
				matrix[i][0] = 0
				matrix[0][j] = 0
			}
		}
	}
	//给除了第一行，列的上0
	for i := 1; i < iLen; i++ {
		for j := 1; j < jLen; j++ {
			if matrix[i][0] == 0 || matrix[0][j] == 0 {
				matrix[i][j] = 0
			}
		}
	}
	//给第一行,列补
	if firstRowZero {
		for i := 0; i < iLen; i++ {
			matrix[i][0] = 0
		}
	}

	if firstCowZero {
		for i := 0; i < jLen; i++ {
			matrix[0][i] = 0
		}
	}
}
