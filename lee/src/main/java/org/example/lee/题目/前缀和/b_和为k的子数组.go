package 前缀和

// 前缀和例题 前缀和: 就是前n项和
func subarraySum(nums []int, k int) int {
	// 用来记录从下标0到i的累加和里出现的数值次数

	m := make(map[int]int)
	sum, answer := 0, 0
	m[0] = 1
	for _, v := range nums {
		sum += v
		//如何理解
		//例子1 : k=4 nums = -1 1 -1 1 0 2 1
		//当下标到4时(即1) sum = 3 ,sum-k=-1,即找到前n项和是-1的即可,
		//毕竟3-(-1) = 4 这样就可以找到两段 即下标为0和下标为2
		//此时answer+=2
		if m[sum-k] != 0 {
			answer += m[sum-k]
		}
		m[sum] = m[sum] + 1
	}
	return answer
}
