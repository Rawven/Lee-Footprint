package 优先队列_堆

import "container/heap"

func topKFrequent(nums []int, k int) []int {
	h := &IntArrHeap{}
	heap.Init(h)
	m := make(map[int][]int)
	for _, num := range nums {
		arr, ok := m[num]
		if ok == true {
			arr[1]++
			m[num] = arr
		} else {
			m[num] = []int{num, 1}
		}
	}
	for _, ints := range m {
		heap.Push(h, ints)
	}
	awe := make([]int, k)

	for i := 0; i < k; i++ {
		awe[i] = heap.Pop(h).([]int)[0]
	}
	return awe

}

type IntArrHeap [][]int

// 实现 heap.Interface 接口
func (h IntArrHeap) Len() int           { return len(h) }
func (h IntArrHeap) Less(i, j int) bool { return h[i][1] > h[j][1] }
func (h IntArrHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

// Push 向堆中推入一个元素
func (h *IntArrHeap) Push(x interface{}) {
	*h = append(*h, x.([]int))
}

// Pop 从堆中移除并返回最小元素
func (h *IntArrHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}
