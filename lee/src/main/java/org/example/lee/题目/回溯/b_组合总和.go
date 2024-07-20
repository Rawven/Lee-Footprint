package 回溯

import "sort"

func combinationSum(candidates []int, target int) [][]int {
	var awe [][]int
	sort.Ints(candidates)
	combinTool(candidates, target, &awe, []int{}, 0)
	return awe
}

func combinTool(candidates []int, target int, awe *[][]int, arr []int, index int) {
	if target == 0 {
		temp := make([]int, len(arr))
		copy(temp, arr)
		*awe = append(*awe, temp)
		arr = arr[:len(arr)-1]
		return
	}
	for i := index; i < len(candidates); i++ {
		arr = append(arr, candidates[i])
		if target-candidates[i] < 0 {
			return
		}
		combinTool(candidates, target-candidates[i], awe, arr, i)
		arr = arr[:len(arr)-1]
	}
}
