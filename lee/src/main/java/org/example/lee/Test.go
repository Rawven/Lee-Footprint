package main

import (
	_ "container/list"
)

func findKthLargest(nums []int, k int) int {
	return partitionTool(nums, 0, len(nums)-1, len(nums)-k)
}

func partitionTool(arr []int, left, right, k int) int {
	h := left
	s1, s2 := left, right
	for left < right {
		for left < right && arr[right] >= arr[h] {
			right--
		}
		for left < right && arr[right] == arr[right-1] {
			right--
		}
		for left < right && arr[left] <= arr[h] {
			left++
		}
		for left < right && arr[left] == arr[left+1] {
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
func main() {
	findKthLargest([]int{3, 3, 3, 3, 4, 3, 3, 3, 3}, 1)
}
