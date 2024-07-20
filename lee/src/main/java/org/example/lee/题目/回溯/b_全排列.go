package 回溯

import "container/list"

func permute(nums []int) [][]int {
	l := list.New()
	for _, v := range nums {
		l.PushFront(v)
	}
	awe := make([][]int, 0, len(nums))
	tool(l, nums, []int{}, &awe)
	return awe
}

func tool(l *list.List, nums, arr []int, awe *[][]int) {
	if len(arr) == len(nums) {
		temp := make([]int, len(arr))
		copy(temp, arr)
		*awe = append(*awe, temp)
		return
	}
	for i := 0; i < l.Len(); i++ {
		v := l.Front().Value.(int)
		l.Remove(l.Front())
		arr = append(arr, v)
		tool(l, nums, arr, awe)
		arr = arr[:len(arr)-1]
		l.PushBack(v)
	}
}
