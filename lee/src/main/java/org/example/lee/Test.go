package main

import _ "container/list"

func main() {
	firstMissingPositive([]int{3, 4, -1, 1})
}
func firstMissingPositive(nums []int) int {

	for i := 0; i < len(nums); i++ {
		for nums[i] > 0 && nums[i] < len(nums) && i != nums[i]-1 {
			a := nums[i]
			nums[i] = nums[nums[i]-1]
			nums[nums[i]-1] = a

		}
	}

	for i := 0; i < len(nums); i++ {
		if nums[i] != i+1 {
			return i + 1
		}
	}
	return len(nums) + 1
}
