package 贪心

func canJump(nums []int) bool {
	max1 := 0
	for i := 0; i < len(nums)-1; i++ {
		max1 = max(max1, i+nums[i])
		if max1 <= i {
			return false
		}
	}
	return true
}
