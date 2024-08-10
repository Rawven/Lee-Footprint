package 贪心

import "math"

func maxProfit(prices []int) int {
	min1, max1 := math.MaxInt32, 0
	for _, v := range prices {
		min1 = min(min1, v)
		max1 = max(max1, v-min1)
	}
	return max1
}
