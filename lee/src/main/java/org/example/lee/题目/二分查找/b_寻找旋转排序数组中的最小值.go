package 二分查找

func findMin(nums []int) int {
	left, right := 0, len(nums)-1
	for left < right {
		mid := left + (right-left)/2
		//最小值在右边区间
		if nums[mid] > nums[right] {
			left = mid + 1
		} else {
			//不然就在左边
			right = mid
		}
	}
	return nums[left]
}
