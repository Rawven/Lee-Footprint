package main

import (
	_ "container/list"
)

func searchInsert(nums []int, target int) int {
	left, right, mid := 0, len(nums)-1, 0
	for left <= right {
		mid = left + (right-left)/2
		if nums[mid] == target {
			return mid
		} else if nums[mid] > target {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return left
}

func main() {
	searchInsert([]int{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3)
}
