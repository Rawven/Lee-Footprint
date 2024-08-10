package 算法实现

// MinHeap 定义一个最小堆的数据结构
type MinHeap struct {
	data []int
}

// NewMinHeap 创建一个新的最小堆
func NewMinHeap() *MinHeap {
	return &MinHeap{
		data: []int{},
	}
}

// Len 返回堆的长度
func (h *MinHeap) Len() int {
	return len(h.data)
}

// Push 向堆中插入一个新元素
func (h *MinHeap) Push(x int) {
	h.data = append(h.data, x)
	h.heapifyUp(h.Len() - 1)
}

// Pop 删除并返回堆顶（最小）元素
func (h *MinHeap) Pop() int {
	if h.Len() == 0 {
		panic("heap is empty")
	}
	min := h.data[0]
	// 将最后一个元素移到堆顶，然后下沉
	h.data[0] = h.data[h.Len()-1]
	h.data = h.data[:h.Len()-1]
	h.heapifyDown(0)
	return min
}

// heapifyUp 上浮操作
func (h *MinHeap) heapifyUp(index int) {
	for h.data[index] < h.data[parent(index)] {
		h.swap(index, parent(index))
		index = parent(index)
	}
}

// heapifyDown 下沉操作
func (h *MinHeap) heapifyDown(index int) {
	smallest := index
	left := leftChild(index)
	right := rightChild(index)

	// 找到最小的子节点
	if left < h.Len() && h.data[left] < h.data[smallest] {
		smallest = left
	}
	if right < h.Len() && h.data[right] < h.data[smallest] {
		smallest = right
	}

	// 如果最小的子节点比当前节点小，进行交换并继续下沉
	if smallest != index {
		h.swap(index, smallest)
		h.heapifyDown(smallest)
	}
}

// parent 返回父节点的索引
func parent(index int) int {
	return (index - 1) / 2
}

// leftChild 返回左子节点的索引
func leftChild(index int) int {
	return 2*index + 1
}

// rightChild 返回右子节点的索引
func rightChild(index int) int {
	return 2*index + 2
}

// swap 交换两个元素的位置
func (h *MinHeap) swap(i, j int) {
	h.data[i], h.data[j] = h.data[j], h.data[i]
}
