package dp

func generate(numRows int) [][]int {
	awe := make([][]int, numRows)
	for i := 0; i < numRows; i++ {
		help := make([]int, i+1)
		help[0] = 1
		help[i+1] = 1
		for j := 1; j < i; j++ {
			help[j] = awe[i-1][j] + awe[i-1][j-1]
		}
		awe[i] = help
	}
	return awe
}
