package 回溯

func subsets(nums []int) [][]int {
	awe := make([][]int, 0)
	awe = append(awe, []int{})
	subTool(&awe, 0, []int{}, nums)
	return awe
}

func subTool(awe *[][]int, index int, arr, nums []int) {
	if index >= len(nums) {
		return
	}
	for i := index; i < len(nums); i++ {
		arr = append(arr, nums[i])
		temp := make([]int, len(arr))
		copy(temp, arr)
		*awe = append(*awe, temp)
		subTool(awe, i+1, arr, nums)
		arr = arr[:len(arr)-1]
	}
}
