package 矩阵

import "container/list"

func rotate(matrix [][]int) {

	// 自己模拟下规律就好
	l := list.New()
	var a int
	lenI, lenJ := len(matrix), len(matrix[0])
	q, p, w := 0, lenI, lenJ
	for a < len(matrix)*len(matrix[0]) {
		for i := q; i < w-1; i++ {
			l.PushBack(matrix[q][i])
			a++
		}
		for i := q; i < p; i++ {
			l.PushBack(matrix[i][w-1])
			matrix[i][w-1] = l.Front().Value.(int)
			l.Remove(l.Front())
			a++
		}
		if a >= len(matrix)*len(matrix[0]) {
			break
		}
		for i := w - 2; i >= q; i-- {
			l.PushBack(matrix[p-1][i])
			matrix[p-1][i] = l.Front().Value.(int)
			l.Remove(l.Front())
			a++
		}
		for i := p - 2; i >= q+1; i-- {
			l.PushBack(matrix[i][q])
			matrix[i][q] = l.Front().Value.(int)
			l.Remove(l.Front())
			a++
		}
		for i := q; i < w-1; i++ {
			matrix[q][i] = l.Front().Value.(int)
			l.Remove(l.Front())
		}
		q++
		p--
		w--
	}
}
