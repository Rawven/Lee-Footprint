package 图

func numIslands(grid [][]byte) int {
	sum := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			//一个个遍历就好
			if grid[i][j] == '1' {
				tool(grid, i, j)
				sum++
			}
		}
	}
	return sum
}
func tool(grid [][]byte, x, y int) {
	if x < 0 || x >= len(grid) || y < 0 || y >= len(grid[0]) || grid[x][y] != '1' {
		return
	}
	grid[x][y] = '0'
	tool(grid, x-1, y)
	tool(grid, x+1, y)
	tool(grid, x, y-1)
	tool(grid, x, y+1)
}
