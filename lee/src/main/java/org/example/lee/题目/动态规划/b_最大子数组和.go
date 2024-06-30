package dp

func maxSubArray(nums []int) int {
	Max, h := nums[0], 0
	for i := 0; i < len(nums); i++ {
		h += nums[i]
		Max = max(Max, h)
		if h <= 0 {
			h = 0
		}
	}
	return Max
}
