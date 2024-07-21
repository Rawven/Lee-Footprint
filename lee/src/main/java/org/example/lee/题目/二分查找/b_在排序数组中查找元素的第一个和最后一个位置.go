package 二分查找

func searchRange(nums []int, target int) []int {
	return []int{
		searchTool(nums, 0, len(nums)-1, target, true),
		searchTool(nums, 0, len(nums)-1, target, false),
	}
}

func searchTool(nums []int, left, right, target int, isLeft bool) int {
	key := -1
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == target {
			key = mid
			if isLeft {
				right = mid - 1
			} else {
				left = mid + 1
			}
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return key
}
