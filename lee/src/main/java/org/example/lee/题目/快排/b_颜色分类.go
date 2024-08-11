package 快排

// 三路划分
func sortColors(nums []int) {
	left, right, move, priot := 0, len(nums)-1, 0, 1
	for move <= right {
		if nums[move] == priot {
			move++
		} else if nums[move] < priot {
			nums[move], nums[left] = nums[left], nums[move]
			left++
			move++
		} else {
			nums[move], nums[right] = nums[right], nums[move]
			right--
		}
	}
}
