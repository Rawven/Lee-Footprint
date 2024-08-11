package 二分查找

// 快速选择做法

func findKthLargest(nums []int, k int) int {
	return partitionTool(nums, 0, len(nums)-1, len(nums)-k)
}

func partitionTool(arr []int, left, right, k int) int {
	pivot := arr[left]
	lt, i, gt := left, left, right

	// 三路分区算法
	for i <= gt {
		if arr[i] < pivot {
			arr[lt], arr[i] = arr[i], arr[lt]
			lt++
			i++
		} else if arr[i] > pivot {
			arr[gt], arr[i] = arr[i], arr[gt]
			gt--
		} else {
			i++
		}
	}

	if k >= lt && k <= gt {
		return arr[lt]
	} else if k < lt {
		return partitionTool(arr, left, lt-1, k)
	} else {
		return partitionTool(arr, gt+1, right, k)
	}
}

//堆做法

// IntHeap 定义一个基于整数的最小堆
type IntHeap []int

// 实现 heap.Interface 接口
func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

// Push 向堆中推入一个元素
func (h *IntHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

// Pop 从堆中移除并返回最小元素
func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func findKthLargest1(nums []int, k int) int {
	h := NewMinHeap()

	for _, num := range nums {
		h.Push(num)
		if h.Len() > k {
			h.Pop()
		}
	}
	return h.Pop()
}
