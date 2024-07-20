package 图

import "container/list"

var save int

func orangesRotting(grid [][]int) int {
	l := list.New()
	save = 0
	//先用队列收集腐烂的橘子
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == 2 {
				l.PushFront([]int{i, j})
			} else if grid[i][j] == 1 {
				save++
			}
		}
	}
	var sum int
	//像层序遍历一般处理
	for l.Len() > 0 && save != 0 {
		num := l.Len()
		for i := 0; i < num; i++ {
			arr := l.Front().Value.([]int)
			l.Remove(l.Front())
			orangeHelp(grid, arr[0]-1, arr[1], l)
			orangeHelp(grid, arr[0]+1, arr[1], l)
			orangeHelp(grid, arr[0], arr[1]-1, l)
			orangeHelp(grid, arr[0], arr[1]+1, l)
		}
		sum++
	}
	if save != 0 {
		return -1
	}
	return sum
}
func orangeHelp(grid [][]int, x, y int, l *list.List) {
	if x < 0 || x >= len(grid) || y < 0 || y >= len(grid[0]) || grid[x][y] != 1 {
		return
	}
	save--
	grid[x][y] = 2
	l.PushBack([]int{x, y})
}
