package 回溯

func exist(board [][]byte, word string) bool {
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			if board[i][j] == word[0] {
				if existTool(i, j, board, word, 0) {
					return true
				}
			}
		}
	}
	return false
}

func existTool(x, y int, board [][]byte, word string, i int) bool {
	if x < 0 || y < 0 || x >= len(board) || y >= len(board[0]) || board[x][y] != word[i] {
		return false
	}
	if i == len(word)-1 {
		return true
	}
	save := board[x][y]
	board[x][y] = '0'
	a := existTool(x-1, y, board, word, i+1)
	b := existTool(x+1, y, board, word, i+1)
	c := existTool(x, y+1, board, word, i+1)
	d := existTool(x, y-1, board, word, i+1)
	board[x][y] = save
	return a || b || c || d
}
