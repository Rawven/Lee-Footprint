package 二分查找

// 快速选择做法
func findKthLargest0(nums []int, k int) int {
	return partitionTool(nums, 0, len(nums)-1, len(nums)-k)
}

func partitionTool(arr []int, left, right, k int) int {

	h := left
	if h == k {
		return arr[h]
	}
	s1, s2 := left, right
	for left < right {
		for left < right && arr[right] >= arr[h] {
			right--
		}
		for left < right && arr[left] <= arr[h] {
			left++
		}
		arr[right], arr[left] = arr[left], arr[right]
	}
	arr[right], arr[h] = arr[h], arr[right]
	if right > k {
		return partitionTool(arr, s1, right-1, k)
	} else if right < k {
		return partitionTool(arr, right+1, s2, k)
	} else {
		return arr[right]
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

func findKthLargest(nums []int, k int) int {
	h := alor_impl.NewMinHeap()

	for _, num := range nums {
		h.Push(num)
		if h.Len() > k {
			h.Pop()
		}
	}
	return h.Pop()
}
