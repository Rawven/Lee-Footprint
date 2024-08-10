package dp

func lengthOfLIS(nums []int) int {
	dp := make([]int, len(nums))
	var mmax int
	for i := 0; i < len(nums); i++ {
		dp[i] = 1
		for j := 0; j <= i; j++ {
			if nums[i] > nums[j] {
				dp[i] = max(dp[j]+1, dp[i])
			}
			mmax = max(mmax, dp[i])
		}
	}
	return mmax
}
