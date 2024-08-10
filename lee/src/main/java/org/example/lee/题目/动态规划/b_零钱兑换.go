package dp

import "sort"

func coinChange(coins []int, amount int) int {
	dp := make([]int, amount+1)
	sort.Ints(coins)
	for i := 1; i < amount+1; i++ {
		dp[i] = amount + 1
		for j := 0; j < len(coins) && coins[j] < i; j++ {
			dp[i] = min(dp[i], dp[i-coins[j]]+1)
		}
	}
	if dp[amount] == amount+1 {
		return -1
	}
	return dp[amount]
}
