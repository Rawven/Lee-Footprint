package 二分查找

func search(nums []int, target int) int {
	return search1(nums, 0, len(nums)-1, target)
}

func search1(nums []int, left, right int, target int) int {
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == target {
			return mid
		} else {
			//左边数组有序
			if nums[left] <= nums[mid] {
				//target位于左边数组
				if nums[left] <= target && nums[mid] > target {
					right = mid - 1
				} else {
					//target位于右边数组
					left = mid + 1
				}
			} else {
				//右边数组有序
				//target位于右边数组
				if nums[right] >= target && nums[mid] < target {
					left = mid + 1
				} else {
					//target位于左边数组
					right = mid - 1
				}
			}
		}
	}
	return -1
}

//TODO 垃圾版本
//func search0(nums []int, left, right, target int) int {
//	if left > right {
//		return -1
//	}
//	mid := left + (right-left)/2
//	if nums[mid] == target {
//		return mid
//	} else if nums[mid] > nums[right] {
//		i := search0(nums, mid+1, right, target)
//		if i != -1 {
//			return i
//		}
//	} else if nums[mid] < nums[left] {
//		i := search0(nums, left, mid-1, target)
//		if i != -1 {
//			return i
//		}
//	}
//	return midSearch(nums, left, right, target)
//}
//func midSearch(nums []int, left, right, target int) int {
//	for left <= right {
//		mid := left + (right-left)/2
//		if nums[mid] == target {
//			return mid
//		} else if nums[mid] < target {
//			left = mid + 1
//		} else {
//			right = mid - 1
//		}
//	}
//	return -1
//}
